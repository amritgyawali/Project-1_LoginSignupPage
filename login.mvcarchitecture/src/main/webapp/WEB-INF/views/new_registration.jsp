<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<body>
	<h2>Registration</h2>
	<pre>
	<form action="RegistrationController" method="post">
		Name<input type="text" name="name">
		Email<input type="text" name="email">
		Password<input type="password" name="password">
		Mobile<input type="text" name="mobile">
		<input type="submit" name="save">
	</form>
	</pre>
	<% 
		if(request.getAttribute("msg")!=null){
			out.println(request.getAttribute("msg"));
		}
	%>
</body>
</html>