package com.example.myweather.model;

public class Weather {
    private String location;
    private String date;
    private double temperature;
    private String skyCondition;
    private double humidity;
    private double wind;

    public Weather(String location, String date, double temperature, String skyCondition, double humidity, double wind) {
        this.location = location;
        this.date = date;
        this.temperature = temperature;
        this.skyCondition = skyCondition;
        this.humidity = humidity;
        this.wind = wind;
    }

    // Getters and setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getSkyCondition() {
        return skyCondition;
    }

    public void setSkyCondition(String skyCondition) {
        this.skyCondition = skyCondition;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }
}