package com.forecastweather.Weather_Forecast.Controller;

import com.forecastweather.Weather_Forecast.Entity.Weather;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {
    private final String apiKey = "864e916ad4cf8a33ac586d2a76babcd4";
    public final String urlTemplate = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid="
            + apiKey + "&units=metric";

    @GetMapping("/weather")
    public ResponseEntity<Object> getWeather(@RequestParam String city){
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(urlTemplate, city);
        String response = restTemplate.getForObject(url, String.class);

        try {
            JSONObject jsonObject = new JSONObject(response);
            String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
            double temperature = jsonObject.getJSONObject("main").getDouble("temp");
            int humidity = jsonObject.getJSONObject("main").getInt("humidity");

            Weather weather = new Weather(description, temperature, humidity);
            return ResponseEntity.ok(weather);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid API key or city name. Please try again.");
        }
    }
}
