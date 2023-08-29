<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('your-scenic-image.jpg'); /* Replace with your image URL */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            color: #fff;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: rgba(0, 0, 0, 0.6);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.6);
        }

        h2 {
            color: #fff;
            text-align: center;
        }

        form {
            text-align: center;
        }

        form input[type="text"],
        form input[type="email"] {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border: none;
            border-radius: 5px;
            background-color: rgba(255, 255, 255, 0.8);
            color: #333;
        }

        form input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        form input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registration</h2>
        <form action="RegistrationController" method="post">
            Name &nbsp;<input type="text" name="name"><br>
            City &nbsp;<input type="text" name="city"><br>
            Email &nbsp;<input type="email" name="email"><br>
            Mobile &nbsp;<input type="text" name="mobile"><br>
            <input type="submit" name="save">
        </form>
        <% 
            if(request.getAttribute("msg")!=null){
                out.println(request.getAttribute("msg"));
            }
        %>
    </div>
</body>
</html>
