package handlers;

import DAO.dataDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by David on 14/05/2015.
 */
@WebServlet(name = "dataViewHandler", urlPatterns = "/data", loadOnStartup = 1)
public class dataViewHandler extends HttpServlet {
    private dataDAO dataDAO = new dataDAO();
    @Override
    public void init() throws ServletException {
        super.init();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                dataDAO.setSensorValues();
                System.out.println("New values added");
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 10000);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        ResultSet humidityRs = dataDAO.getHumidity();
        ResultSet lightRs = dataDAO.getLight();
        ResultSet temperatureRs = dataDAO.getTemperature();
        ResultSet idRs = dataDAO.getId();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>");
        writer.println("Data View");
        writer.println("</title>");
        writer.println("<link href=\"css/main.css\" rel=\"stylesheet\">");
        writer.println("<script src=\"javascript/dataViewController.js\"></script>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<header>Data</header>");
        writer.println("<nav>");
        writer.println("<ul class='navBar'>");
        writer.println("<li class='navButton'><a href='/data' class='navLink'>Data View</a></li>");
        writer.println("<li class='navButton'><a href='/setup' class='navLink'>Setup</a></li>");
        writer.println("<li class='navButton'><a href='/notifications' class='navLink'>Notifications</a></li>");
        writer.println("<li class='navButton'><a href='index.html' class='navLink'>Home</a></li>");
        writer.println("</ul>");
        writer.println("</nav>");
        writer.println("<div id= 'dataTable'>");
        writer.println("<table class='notificationConsole'>");
        writer.println("<tr>");
        writer.println("<td>ID</td>");
        try {
            while (idRs.next()) {
                int id = idRs.getInt("ID");
                writer.println("<td class='notificationConsoleResult'>" + id + "</td>");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Temperature</td>");
        try {
            while (temperatureRs.next()) {
                int temperature = temperatureRs.getInt("temperature");
                writer.println("<td class='notificationConsoleResult'>" + temperature + "&#8451" + "</td>");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Humidity</td>");
        try {
            while (humidityRs.next()) {
                int humidity = humidityRs.getInt("humidity");
                writer.println("<td class='notificationConsoleResult'>" + humidity + "%" + "</td>");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        writer.println("</tr>");
        writer.print("<tr>");
        writer.println("<td>Light</td>");
        try {
            while (lightRs.next()) {
                int light = lightRs.getInt("light");
                writer.println("<td class='notificationConsoleResult'>" + light + "</td>");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        writer.print("</tr>");
        writer.println("</table>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
