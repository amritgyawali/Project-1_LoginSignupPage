<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update Registration</h2>
<form action="update" method="post">
            Email <input type="email" name="email" value="<%=request.getAttribute("email")%>"/><br>
            Mobile <input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/><br>
            <input type="submit" value="update">
        </form>
</body>
</html>