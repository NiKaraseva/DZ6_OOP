package org.example;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherapiModel implements WeatherModel{

    //https://api.weatherapi.com/v1/forecast.json?key=72c147eedfc441b28e5195331230303&q=Paris&days=1&aqi=no&alerts=no
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "api.weatherapi.com";
    private static final String VERSION = "v1";
    private static final String FORECASTS = "forecast.json";
    private static final String API_KEY = "72c147eedfc441b28e5195331230303";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String CITY = "Paris";
    private static final String ONE_DAY = "1";
    private static final String AQI = "no";
    private static final String ALERTS = "no";




    private static final OkHttpClient okHttpClient = new OkHttpClient();
//    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void getWeather(String selectedCity, Period period) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(VERSION)
                .addPathSegment(FORECASTS)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addPathSegment(CITY)
                .addPathSegment(ONE_DAY)
                .addPathSegment(AQI)
                .addPathSegment(ALERTS)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response currentForecastResponse = okHttpClient.newCall(request).execute();
        String weatherResponse1 = currentForecastResponse.body().string();
        System.out.println(weatherResponse1);
    }

}
