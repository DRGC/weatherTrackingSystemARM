package handlers;

import DAO.notificationsDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by David on 28/05/15.
 */
@WebServlet(name = "notificationsHandler", urlPatterns = "/notifications")
public class notificationsHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            notificationsDAO dao = new notificationsDAO();
            String email = request.getParameter("email");
            int temperature = Integer.parseInt(request.getParameter("temperatureThreshold"));
            int humidity = Integer.parseInt(request.getParameter("humidityThreshold"));
            int light = Integer.parseInt(request.getParameter("lightThreshold"));

            System.out.println(email);
            System.out.println(temperature);
            System.out.println(humidity);
            System.out.println(light);

            dao.addNotification(email, temperature, humidity, light);
            response.sendRedirect("/notifications");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        notificationsDAO notificationsDAO = new notificationsDAO();
        ResultSet notificationsRs = null;
        try {
            notificationsRs = notificationsDAO.getNotifications();
        } catch (SQLException e) {
            System.out.println(e);
        }
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>");
        writer.println("Data View");
        writer.println("</title>");
        writer.println("<link href=\"css/main.css\" rel=\"stylesheet\">");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<header>Notifications</header>");
        writer.println("<nav>");
        writer.println("<ul class='navBar'>");
        writer.println("<li class='navButton'><a href='/data' class='navLink'>Data View</a></li>");
        writer.println("<li class='navButton'><a href='/setup' class='navLink'>Setup</a></li>");
        writer.println("<li class='navButton'><a href='/notifications' class='navLink'>Notifications</a></li>");
        writer.println("<li class='navButton'><a href='index.html' class='navLink'>Home</a></li>");
        writer.println("</ul>");
        writer.println("</nav>");
        writer.println("<table class='notificationConsole'>");
        writer.println("<tr>");
        writer.println("<th>E-mail</th>");
        writer.println("<th>Temperature Threshold</th>");
        writer.println("<th>Humidity Threshold</th>");
        writer.println("<th>Light Threshold</th>");
        writer.println("</tr>");
        writer.println("<tr>");
        try {
            while (notificationsRs.next()) {
                String email = notificationsRs.getString("email");
                int temperatureThreshold = notificationsRs.getInt("temperatureThreshold");
                int humidityThreshold = notificationsRs.getInt("humidityThreshold");
                int lightThreshold = notificationsRs.getInt("lightThreshold");
                writer.println("<td class='notificationConsoleResult'>" + email + "</td>");
                writer.println("<td class='notificationConsoleResult'>" + temperatureThreshold + "&#8451" + "</td>");
                writer.println("<td class='notificationConsoleResult'>" + humidityThreshold + "%" + "</td>");
                writer.println("<td class='notificationConsoleResult'>" + lightThreshold + "</td>");
                writer.println("</tr>");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        writer.println("</table>");
        writer.println("<form id=\"notificationsForm\" method=\"post\" action=\"/notifications\">");
        writer.println("<legend><h2>Notifications</h2></legend>");
        writer.println("<fieldset>");
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<th><label for=\"email\">E-mail:</label></th>");
        writer.println("<th><label for=\"temperatureThreshold\">Temperature Threshold:</label></th>");
        writer.println("<th><label for=\"humidityThreshold\">Humidity Threshold:</label></th>");
        writer.println("<th><label for=\"lightThreshold\">Light Threshold:</label></th>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td><input type=\"email\" id=\"email\" name= 'email' required/></td>");
        writer.println("<td><input type=\"number\" id=\"temperatureThreshold\" name='temperatureThreshold'></td>");
        writer.println("<td><input type=\"number\" id=\"humidityThreshold\" name='humidityThreshold'></td>");
        writer.println("<td><input type=\"number\" id=\"lightThreshold\" name ='lightThreshold'></td>");
        writer.println("<td><input type=\"submit\" value=\"Add\" name=\"submit\"></td>");
        writer.println("</tr>");
        writer.println("</table>");
        writer.println("</fieldset>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
