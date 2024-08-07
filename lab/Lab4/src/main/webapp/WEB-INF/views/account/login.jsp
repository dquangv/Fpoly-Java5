<%--
  Created by IntelliJ IDEA.
  User: Quang
  Date: 8/7/2024
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <title>Login</title>
</head>
<body>
<div class="container" style="margin-top: 10px;">
    <div class="row"
         style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <h2>Login Form</h2>
            <form action="/account/login" method="post">
                <div class="form-group">
                    <label>UserName</label> <input type="text" class="form-control"
                                                   name="username" value="" placeholder="Enter UserName">
                </div>
                <div class="form-group">
                    <label>Password:</label> <input type="password"
                                                    class="form-control" name="password" value=""
                                                    placeholder="Enter password">
                </div>
                <div class="form-group">
                    <label>Remember me?:</label> <input type="checkbox"
                                                        class="form-check" name="remember" value="">
                </div>
                <button class="btn btn-primary">Login</button><br>
                <div class="badge text-bg-danger">
                    ${message}
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
