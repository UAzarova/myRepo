package lesson6;

import okhttp3.HttpUrl;
import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Java 2. Home work 6.
 *
 * @author Azarova Iuliia
 * @version 23.04.2022
 */

/*
 * 1. С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
 * пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
 *
 * 2. Подобрать источник самостоятельно. Можно использовать api accuweather, порядок следующий:
 * зарегистрироваться, зарегистрировать тестовое приложение для получения api ключа, найдите нужный endpoint и изучите документацию.
 */



public class Main {
    public static <JsonObject, JsonArray, JsonElement> void main(String[] args) throws IOException {

        final String PROTOKOL = "https";
        final String BASE_HOST = "dataservice.accuweather.com";
        final String FORECASTS = "forecasts";
        final String VERSION = "v1";
        final String DAILY = "daily";
        final String DAYS = "5day";
        final int DAYSINT = 5;
        final String API_KEY = "6cH9wi14krg6LUFvm0AhX4S91yK4RULd";
        final String API_KEY_QUERY_PARAM = "apikey";
        final String CITY_ID = "295212";
        final String LANGUAGE_QUERY_PARAM = "language";
        final String LANGUAGE = "ru-RU";
        final String DETAILS_QUERY_PARAM = "details";
        final String DETAILS = "false";
        final String METRIC_QUERY_PARAM = "metric";
        final String METRIC = "true";

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
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
        System.out.println(jsonObjectWeather);

        JSONArray dailyForecastsArray = (JSONArray)jsonObjectWeather.get("DailyForecasts");

        List<Weather> weatherList = new ArrayList<>();

        for (int i = 0; i < DAYSINT; i++) {
            JSONObject weatherData = (JSONObject)dailyForecastsArray.get(i);
            String date = (String)weatherData.get("Date");
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
            weatherList.add(tmp);
        }

        System.out.println(weatherList);






//        String forecast = (String) weatherData.get("IconPhrase");


//        System.out.println(date);
//        System.out.println(temperature);
//        System.out.println(forecast);
    }
}
