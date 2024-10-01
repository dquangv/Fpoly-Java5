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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f0f0f0;
        }
        /* .container {
            max-width: 500px;
            margin-top: 50px;
            background-color: #ffffff;
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        } */
        .form-group {
            margin-bottom: 20px;
        }
        .form-control {
            height: 40px;
            padding: 10px;
            font-size: 16px;
        }
        .btn-primary {
            width: 100%;
            height: 40px;
            font-size: 16px;
            font-weight: bold;
        }
        #message {
            margin-top: 10px;
            padding: 10px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="row">
        <div class="col-sm-12">
            <h2>Login Form</h2>
            <form id="loginForm">
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" class="form-control" name="username" placeholder="Enter Username" value="${savedUsername}">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" name="password" placeholder="Enter Password" value="${savedPassword}">
                </div>
                <div class="form-group">
                    <input type="checkbox" class="form-check" name="remember" style="display: inline-block;">
                    <label style="display: inline-block; margin-left: 5px;">Remember me?</label>
                </div>
                <button type="button" class="btn btn-primary" id="loginBtn">Login</button>
                <div id="message" class="badge text-bg-danger">${message}</div>
            </form>
        </div>
    </div>

<script>
    $('#loginBtn').click(function(e) {
        e.preventDefault(); // Prevent default form submission
        
        $.ajax({
            url: '${pageContext.request.contextPath}/account/login',
            type: 'POST',
            data: $('#loginForm').serialize(), // Serialize form data
            success: function(response) {
                $('#message').html(response.message);  // Display response message
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
                $('#message').html('Login failed');
            }
        });
    });
</script>
</body>
</html>
