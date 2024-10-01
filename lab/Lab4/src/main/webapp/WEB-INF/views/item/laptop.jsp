<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab 4 bài 5</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f0f0f0;
        }
        .cards {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .card {
            width: calc(25% - 20px);
            margin: 10px;
            background-color: #ffffff;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            padding: 20px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
        }
        .card .info {
            text-align: center;
        }
        .card .info h2 {
            margin-top: 0;
        }
        .card .price {
            font-weight: bold;
            color: #007bff;
        }
        .card .action {
            margin-top: 10px;
        }
        .card .action a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
        .card .action a:hover {
            text-decoration: underline;
        }
        .card img {
            width: 100%;
            height: auto;
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <h1>Shopping Now</h1>
    <div class="cards">
    <c:forEach var="item" items="${items}">
        <div class="card">
            <div class="info">
                <h2>${item.name}</h2>
                <img src="${item.image}" alt="${item.name}" width="150" height="150"> 
                <p class="price">$${item.price}</p>
            </div>
            <div class="action">
                <a href="/cart/add/${item.id}">Add To Cart</a>
            </div>
        </div>
    </c:forEach>
</div>

    <script>
    function addToCart(itemId) {
        $.ajax({
            url: '${pageContext.request.contextPath}/cart/add/' + itemId,
            type: 'POST',
            success: function(response) {
                loadContent('cart/view');
            },
            error: function(xhr, status, error) {
                console.error('Error adding item to cart:', error);
            }
        });
    }
    </script>
</body>

</body>
</html>
