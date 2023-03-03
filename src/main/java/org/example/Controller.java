package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    private WeatherModel weatherModel1 = new AccuweatherModel();
    private WeatherModel weatherModel2 = new WeatherapiModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.ONE_DAY);
        variants.put(5, Period.FIVE_DAYS);
    }


    public void getWeather(String choice, String command, String city) throws IOException {
            Integer userOption = Integer.parseInt(command);

            if (choice.equals("1")) {
                switch (variants.get(userOption)) {
                    case ONE_DAY:
                        weatherModel1.getWeather(city, Period.ONE_DAY);
                        break;
                    case FIVE_DAYS:
                        weatherModel1.getWeather(city, Period.FIVE_DAYS);
                        break;
                }
            }
            else {
                weatherModel2.getWeather(city, Period.ONE_DAY);
            }

        }
    }



