<%--
  Created by IntelliJ IDEA.
  User: Quang
  Date: 7/8/2024
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
</head>
<body>
<h1> Cookie information: ${userCookie}</h1>
<h1>${courseInfo}</h1>
<form action="/login" method="post">
    Username: <input type="text" name="username" placeholder="Username"><br>
    Password: <input type="password" name="password" placeholder="Password"><br>
    <button>Submit</button><br>
    Tên: ${user} Password: ${pass}
</form>
</body>
</html>