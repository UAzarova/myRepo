package lesson8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database<connection> {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/java_gb";
    private static final String DB_LOGIN = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private String insertWeather = "insert into forecast (city, date, forecast, temperature) values (?, ?, ?, ?)";
    private String getWeather = "select * from forecast";
    private String cleanDatabase = "delete from forecast";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveForecastToDB(List<Weather> weatherList) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DB_LOGIN, DB_PASSWORD)) {
            PreparedStatement saveToDB = connection.prepareStatement(insertWeather);
            for (Weather weather : weatherList) {
                saveToDB.setString(1, weather.getCity());
                saveToDB.setString(2, weather.getDate());
                saveToDB.setString(3, weather.getForecastDay());
                saveToDB.setDouble(4, weather.getAverageTemperature(weather.getTemperatureMin(), weather.getTemperatureMax()));
                saveToDB.addBatch();
            }
            saveToDB.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("successful save to database!");
    }

    public void getForecastFromDB() {
        List<Weather> weathers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DB_LOGIN, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);
            while (resultSet.next()) {

                System.out.println("\nГород: " + resultSet.getString("city"));
                System.out.println("Дата: " + resultSet.getString("date"));
                System.out.println("Прогноз: " + resultSet.getString("forecast"));
                System.out.println("Температура: " + resultSet.getDouble("temperature"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cleanDB() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DB_LOGIN, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(cleanDatabase);
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Forecast was cleaned!");
    }
}


