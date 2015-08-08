package DAO;

import java.sql.*;

/**
 * Created by David on 28/05/15.
 */
public class notificationsDAO {
    private Connection connection;
    private ResultSet rs;
    public notificationsDAO(){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("config SQL Error: " + e.getMessage());
            }
            connection = DriverManager.getConnection("jdbc:mysql://localhost/weathertrackingdb", "CP2011", "hello@123");
        } catch (SQLException e) {
            System.out.println("config Driver Error: " + e.getMessage());
            connection = null;
        }
    }
    public void addNotification(String email, int temperatureThreshold, int humidityThreshold, int lightThreshold ) {
        try {
            String sql = "INSERT INTO notifications (email, temperatureThreshold, humidityThreshold,lightThreshold) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setInt(2, temperatureThreshold);
            statement.setInt(3, humidityThreshold);
            statement.setInt(4, lightThreshold);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("addNotification error: " + e.getMessage());
        }
    }
    public ResultSet getNotifications() throws SQLException {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("getTemperature SQL Error: " + e.getMessage());
            }
            connection = DriverManager.getConnection("jdbc:mysql://localhost/weathertrackingdb", "CP2011", "hello@123");
        } catch (SQLException e) {
            System.out.println("getTemperature Driver Error: " + e.getMessage());
            connection = null;
        }
        try {
            String sql = "SELECT * FROM notifications";
            PreparedStatement statement = connection.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rs;
    }

}
