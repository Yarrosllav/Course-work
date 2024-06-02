package com.example.myweather.controller;

import com.example.myweather.model.Weather;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
    private Map<String, Weather> weatherData = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String location = request.getParameter("location");
        String dateStr = request.getParameter("date");

        try {
            LocalDate date = LocalDate.parse(dateStr);
            if (date.isBefore(LocalDate.now())) {
                request.setAttribute("message", "The selected date has already passed.");
                request.getRequestDispatcher("weatherResult.jsp").forward(request, response);
                return;
            }

            String key = location + "_" + dateStr;
            Weather weather = weatherData.get(key);

            if (weather != null) {
                request.setAttribute("weather", weather);
            } else {
                request.setAttribute("message", "No weather data found for the given location and date.");
            }

        } catch (DateTimeParseException e) {
            request.setAttribute("message", "Invalid date format.");
        }

        request.getRequestDispatcher("weatherResult.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String location = request.getParameter("location");
        String dateStr = request.getParameter("date");

        try {
            LocalDate date = LocalDate.parse(dateStr);
            if (date.isBefore(LocalDate.now())) {
                request.setAttribute("message", "The selected date has already passed.");
                request.getRequestDispatcher("admin.jsp").forward(request, response);
                return;
            }

            double temperature = Double.parseDouble(request.getParameter("temperature"));
            String skyCondition = request.getParameter("skyCondition");
            double humidity = Double.parseDouble(request.getParameter("humidity"));
            double wind = Double.parseDouble(request.getParameter("wind"));

            Weather weather = new Weather(location, dateStr, temperature, skyCondition, humidity, wind);
            String key = location + "_" + dateStr;
            weatherData.put(key, weather);

            request.setAttribute("message", "Weather data saved successfully.");

        } catch (DateTimeParseException e) {
            request.setAttribute("message", "Invalid date format.");
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Invalid number format.");
        }

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}