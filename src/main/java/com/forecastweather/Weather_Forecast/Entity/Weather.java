package com.forecastweather.Weather_Forecast.Entity;

public class Weather {
    private String description;
    private double temperature;
    private int humidity;

    public Weather(String description, double temperature, int humidity) {
        this.description = description;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
