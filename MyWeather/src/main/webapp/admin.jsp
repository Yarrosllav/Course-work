<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Admin Page</h1>
    <form action="weather" method="post">
        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required autocomplete="off">
        <br>
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required autocomplete="off">
        <br>
        <label for="temperature">Temperature, C:</label>
        <input type="number" step="0.1" id="temperature" name="temperature" required autocomplete="off">
        <br>
        <label for="skyCondition">Sky:</label>
        <input type="text" id="skyCondition" name="skyCondition" required autocomplete="off">
        <br>
        <label for="humidity">Humidity, %:</label>
        <input type="number" step="0.1" id="humidity" name="humidity" required autocomplete="off">
        <br>
        <label for="wind">Wind, m/s:</label>
        <input type="number" step="0.1" id="wind" name="wind" required autocomplete="off">
        <br>
        <button type="submit">Save Weather Data</button>
    </form>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
    <p><%= message %></p>
    <%
        }
    %>
    <a href="index.jsp">Logout</a>
</div>
</body>
</html>