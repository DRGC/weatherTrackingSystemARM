package Generator;
import DAO.dataDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * Created by David on 2/06/15.
 */
public class NumberGenerator {
    private static boolean tempOn = false;
    private static boolean humidityOn = false;
    private static boolean lightOn = false;
    private dataDAO dao = new dataDAO();
    private ResultSet notifications = dao.getNotifications();

    public int temperatureGenerator() {
        if (tempOn) {
            Random random = new Random();
            int min = 16;
            int max = 38;
            int temperatureResult = random.nextInt(max - min) + min;
            try {
                while (notifications.next()) {
                    String email = notifications.getString("email");
                    int temperatureThreshold = notifications.getInt("temperatureThreshold");
                    if (temperatureResult >= temperatureThreshold) {
                        System.out.println("Temperature threshold reached: " + email);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            return temperatureResult;
        } else {
            return -1;
        }

    }
    public int humidityGenerator() {
        if (humidityOn) {
            Random random = new Random();
            int min = 10;
            int max = 90;
            int humidityResult = random.nextInt(max - min) + min;
            try {
                notifications = dao.getNotifications();
                while (notifications.next()) {
                    String email = notifications.getString("email");
                    int humidityThreshold = notifications.getInt("humidityThreshold");
                    System.out.println(humidityThreshold);
                    if (humidityResult >= humidityThreshold) {
                        System.out.println("Humidity threshold reached: " + email);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            return humidityResult;
        } else {
            return -1;
        }

    }
    public int lightGenerator() {
        if (lightOn) {
            Random random = new Random();
            int min = 0;
            int max = 100;
            int lightResult = random.nextInt(max - min) + min;
            notifications = dao.getNotifications();
            try {
                while (notifications.next()) {
                    String email = notifications.getString("email");
                    int lightThreshold = notifications.getInt("lightThreshold");
                    System.out.println(lightThreshold);
                    if (lightResult >= lightThreshold) {
                        System.out.println("Light threshold reached: " + email);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            return lightResult;
        } else {
            return -1;
        }

    }
    public void enableTemperature(boolean selection) {
        tempOn = selection;
    }
    public void enableHumidity(boolean selection) {
        humidityOn = selection;
    }
    public void enableLight(boolean selection) {
        lightOn = selection;
    }
}
