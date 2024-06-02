<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Admin Login</h1>
    <form action="admin" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required autocomplete="off">
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required autocomplete="off">
        <br>
        <button type="submit">Login</button>
    </form>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
    <p><%= message %></p>
    <%
        }
    %>
    <a href="index.jsp">Back to Home</a>
</div>
</body>
</html>