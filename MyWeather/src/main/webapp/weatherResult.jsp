<%@ page import="com.example.myweather.model.Weather" %>
<!DOCTYPE html>
<html>
<head>
    <title>Weather Result</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Weather Result</h1>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
    <p><%= message %></p>
    <%
    } else {
        Weather weather = (Weather) request.getAttribute("weather");
        if (weather != null) {
    %>
    <p>Location: <%= weather.getLocation() %></p>
    <p>Date: <%= weather.getDate() %></p>
    <p>Temperature: <%= weather.getTemperature() %>C</p>
    <p>Sky: <%= weather.getSkyCondition() %></p>
    <p>Humidity: <%= weather.getHumidity() %>%</p>
    <p>Wind: <%= weather.getWind() %> m/s</p>
    <%
            }
        }
    %>
    <a href="index.jsp">Back to Home</a>
</div>
</body>
</html>