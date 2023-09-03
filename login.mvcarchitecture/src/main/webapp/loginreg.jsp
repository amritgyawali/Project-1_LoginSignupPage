<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Signup</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            background-color: #fff;
            border-radius: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        form {
        max-width: 500px;
            margin: 0 auto;
            padding: 30px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        label {
            font-weight: bold;
            margin-top: 10px;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 90%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
            margin-top: 10px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .message {
            color: #d9534f;
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Signup</h2>
    <form action="loginreg" method="post">
        <label for="name">Name</label>
        <input type="text" name="name" required><br>
        
        <label for="email">Email</label>
        <input type="email" name="email" required><br>
        
        <label for="password">Password</label>
        <input type="password" name="password" required><br>
        
        <label for="mobile">Mobile</label>
        <input type="text" name="mobile" required><br>
        
        <input type="submit" value="Signup">
    </form>
    <% 
        if(request.getAttribute("msg")!=null){
            out.println("<p class='message'>" + request.getAttribute("msg") + "</p>");
        }
    %>
</div>
</body>
</html>
