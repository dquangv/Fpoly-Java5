<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab 4</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            /* margin: 0;
            padding: 0; */
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
        }
        .navbar a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .content {
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="#" onclick="loadContent('account/login')">Log In</a>
        <a href="#" onclick="loadContent('item/index')">Item List</a>
        <a href="#" onclick="loadContent('cart/view')">Cart</a>
    </div>

    <div id="content" class="content">
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function loadContent(page) {
            $.ajax({
                url: '${pageContext.request.contextPath}/' + page,
                type: 'GET',
                success: function(response) {
                    $('#content').html(response);
                },
                error: function(xhr, status, error) {
                    console.error('Error loading content:', error);
                }
            });
        }

        $(document).ready(function() {
            loadContent('account/login');
        });
    </script>
</body>
</html>
