package DAO;
import Generator.NumberGenerator;

import java.sql.*;
import java.util.Random;

/**
 * Created by David on 29/05/15.
 */
public class dataDAO {
    private Connection connection;
    private ResultSet rs;
    public dataDAO() {
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
    }
    public ResultSet getHumidity() {
        try {
            String sql = "SELECT humidity FROM variables";
            PreparedStatement statement = connection.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rs;
    }
    public ResultSet getTemperature() {
        try {
            String sql = "SELECT temperature FROM variables";
            PreparedStatement statement = connection.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rs;
    }
    public ResultSet getLight() {
        try {
            String sql = "SELECT light FROM variables";
            PreparedStatement statement = connection.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rs;
    }
    public ResultSet getId() {
        try {
            String sql = "SELECT ID FROM variables";
            PreparedStatement statement = connection.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rs;
    }
    public void setSensorValues() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int temperatureResult = numberGenerator.temperatureGenerator();
        int humidityResult = numberGenerator.humidityGenerator();
        int lightResult = numberGenerator.lightGenerator();
        String sql = "INSERT INTO variables (temperature, humidity, light) " + "VALUES " + "(" + temperatureResult + "," + humidityResult + "," + lightResult + ")";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public ResultSet getNotifications() {
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
