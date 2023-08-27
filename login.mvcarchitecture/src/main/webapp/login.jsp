<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta name="description" content="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    </head>
    <body>
       <div class="wrapper">
		<form action="verifyLogin" method="post">
			<h1>Login</h1>
			<div class="input-box">
				<input type="text" name="email" placeholder="Email" required>
                <i class='bx bxs-user'></i>
			</div>
			<div class="input-box">
				<input type="password" name="password" placeholder="Password" required>
                <i class='bx bxs-lock-alt'></i>
			</div>

			<div class="remember-forgot">
				<label><input type="checkbox">Remember me </label>
				<a href="#">Forgot password?</a>
			</div>
			
			<button type="submit" class="btn">Login</button>
			<div class="register-link">
				<p>Don't have an account? <a href="/WEB-INF/views/new_registration.jsp">Register</a></p>
			</div>
		</form>
	</div>
	<%
	if(request.getAttribute("error")!=null){
		out.println(request.getAttribute("error"));
	}
	%>
        
      
    </body>
</html>