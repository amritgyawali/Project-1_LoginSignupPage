<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #F4EAE7;
            padding: 20px;
        }

        a {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            background-color: #ff6347;
            color: #F4EAE7;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s ease;
            font-family: 'Arial', sans-serif; /* Add a stylish font here */
        }

        a:hover {
            background-color: #0056b3;
        }
        .logout {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            background-color: #ff6347;
            color: #F4EAE7;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s ease;
            font-family: 'Arial', sans-serif; /* Add a stylish font here */
        }

    </style>
</head>
<body>
    <a href="RegistrationController">New Registration</a>
    <a href="allReg">All Registration</a>
    <form action="logout" method="post">
        <input type="submit" class="logout" value="Logout"> <!-- Added class "logout" -->
    </form>
</body>
</html>
