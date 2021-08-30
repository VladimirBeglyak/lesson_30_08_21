<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Registration Form</title>
</head>
<body>
<h1>Guru Register Form</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table style="with: 50%">
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        </table>
    <input type="submit" value="Submit" />
    
</form>
</body>
</html>