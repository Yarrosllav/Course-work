<!DOCTYPE html>
<html>
<head>
    <title>Weather App</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Weather App</h1>
    <form action="weather" method="get">
        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required autocomplete="off">
        <br>
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required autocomplete="off">
        <br>
        <button type="submit">Get Weather</button>
    </form>
    <br>
    <a href="adminLogin.jsp">Login as Admin</a>
</div>
</body>
</html>