package handlers;
import Generator.NumberGenerator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by David on 14/05/2015.
 */
@WebServlet(name = "setupHandler", urlPatterns = "/setup")
public class setupHandler extends HttpServlet {
    private final static int TemperatureIndex = 0;
    private final static int HumidityIndex = 1;
    private final static int LightIndex = 2;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            NumberGenerator numberGenerator = new NumberGenerator();
            String[] checkboxValues = request.getParameterValues("sensor");
            boolean[] setSensors = new boolean[3];
            if (checkboxValues != null) {
                for (int i = 0; i < checkboxValues.length; ++i) {
                    int value;
                    value = Integer.parseInt(checkboxValues[i]) - 1;
                    setSensors[value] = true;
                }
            } if (checkboxValues == null) {
                setSensors[0] = false;
                setSensors[1] = false;
                setSensors[2] = false;
            }

            System.out.println("Temperature On: " + setSensors[0]);
            System.out.println("Humidity On: " + setSensors[1]);
            System.out.println("Light On:" + setSensors[2]);

            numberGenerator.enableTemperature(setSensors[TemperatureIndex]);
            numberGenerator.enableHumidity(setSensors[HumidityIndex]);
            numberGenerator.enableLight(setSensors[LightIndex]);
            response.sendRedirect("/setup");





        }catch (RuntimeException e){
            e.printStackTrace();
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>");
        writer.println("Setup");
        writer.println("</title>");
        writer.println("<link href=\"css/main.css\" rel=\"stylesheet\">");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<header>Setup</header>");
        writer.println("<nav>");
        writer.println("<ul class='navBar'>");
        writer.println("<li class='navButton'><a href='/data' class='navLink'>Data View</a></li>");
        writer.println("<li class='navButton'><a href='/setup' class='navLink'>Setup</a></li>");
        writer.println("<li class='navButton'><a href='/notifications' class='navLink'>Notifications</a></li>");
        writer.println("<li class='navButton'><a href='index.html' class='navLink'>Home</a></li>");
        writer.println("</ul>");
        writer.println("</nav>");
        writer.println("<form id=\"setupForm\" method=\"post\" action=\"/setup\">");
        writer.println("<legend><h2>Toggle On:</h2></legend>");
        writer.println("<fieldset>");
        writer.println("<p><label for=\"temperatureSensor\">Temperature Sensor:</label><input type=\"checkbox\" id=\"temperatureSensor\" name = 'sensor' value='1'/></p>");
        writer.println("<p><label for=\"humiditySensor\">Humidity Sensor:</label><input type=\"checkbox\" id=\"humiditySensor\" name = 'sensor' value='2'/></p>");
        writer.println("<p><label for=\"lightSensor\">Light Sensor:</label><input type=\"checkbox\" id=\"lightSensor\" name='sensor' value='3'/></p>");
        writer.println("<p><input type=\"submit\" value=\"Submit\" name=\"submit\"/></p>");
        writer.println("</fieldset>");
        writer.println("</form>");
        writer.println("<script src=\"javascript/setupController.js\"></script>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
