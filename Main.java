package lesson8;

import okhttp3.HttpUrl;
import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Java 2. Home work 8.
 *
 * @author Azarova Iuliia
 * @version 04.05.2022
 */

/*
 * 2. Создать класс-репозиторий, отвечающий за взаимодействие с базой данных.
 * 3. Организовать запись данных в базу при каждом успешном API запросе.
 *    Формат - String city, String localDate, String weatherText, Double temperature.
 * 4. Организовать чтение из базы всех данных по пункту меню (требует переработки меню)
 * 5. Учесть, что соединение всегда нужно закрывать
 */



public class Main {
    public static <JsonObject, JsonArray, JsonElement> void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        final String PROTOCOL = "https";
        final String BASE_HOST = "dataservice.accuweather.com";
        final String FORECASTS = "forecasts";
        final String VERSION = "v1";
        final String DAILY = "daily";
        final String DAYS = "5day";
        final int DAYS_INT = 5;
        final String API_KEY = "6cH9wi14krg6LUFvm0AhX4S91yK4RULd";
        final String API_KEY_QUERY_PARAM = "apikey";
        final String CITY_ID = "295212";
        final String CITY_ID_NAME_295212 = "Санкт-Петербург";
        final String LANGUAGE_QUERY_PARAM = "language";
        final String LANGUAGE = "ru-RU";
        final String DETAILS_QUERY_PARAM = "details";
        final String DETAILS = "false";
        final String METRIC_QUERY_PARAM = "metric";
        final String METRIC = "true";

        System.out.println("Trying to get forecast..");

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(VERSION)
                .addPathSegment(DAILY)
                .addPathSegment(DAYS)
                .addPathSegment(CITY_ID)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE)
                .addQueryParameter(DETAILS_QUERY_PARAM, DETAILS)
                .addQueryParameter(METRIC_QUERY_PARAM, METRIC)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response forecastResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = forecastResponse.body().string();

        JSONObject jsonObjectWeather = (JSONObject)JSONValue.parse(weatherResponse);
//        System.out.println(jsonObjectWeather);

        JSONArray dailyForecastsArray = (JSONArray)jsonObjectWeather.get("DailyForecasts");

        List<Weather> weatherList = new ArrayList<>();
        Database database = new Database();


        for (int i = 0; i < DAYS_INT; i++) {
            JSONObject weatherData = (JSONObject)dailyForecastsArray.get(i);
            String date = (String)weatherData.get("Date");
            date = date.substring(0, 10);
            JSONObject temperatureJson = (JSONObject)weatherData.get("Temperature");
            JSONObject minTemperatureJson = (JSONObject)temperatureJson.get("Minimum");
            Double minTemperature = (Double)minTemperatureJson.get("Value");
            JSONObject maxTemperatureJson = (JSONObject)temperatureJson.get("Maximum");
            Double maxTemperature = (Double)maxTemperatureJson.get("Value");
            JSONObject forecastJsonNight = (JSONObject)weatherData.get("Night");
            JSONObject forecastJsonDay = (JSONObject)weatherData.get("Day");
            String forecastNight = (String)forecastJsonNight.get("IconPhrase");
            String forecastDay = (String)forecastJsonDay.get("IconPhrase");
            Weather tmp = new Weather(date, minTemperature, maxTemperature, forecastDay, forecastNight);
            tmp.setCity(CITY_ID_NAME_295212);
            weatherList.add(tmp);
        }

//        System.out.println(weatherList);

        System.out.println("\nTrying to save to database..");
        database.saveForecastToDB(weatherList);

        System.out.println("\nLoad forecast from database..");
        database.getForecastFromDB();
        System.out.println("\nGreat work!");

        database.cleanDB();
    }
}
