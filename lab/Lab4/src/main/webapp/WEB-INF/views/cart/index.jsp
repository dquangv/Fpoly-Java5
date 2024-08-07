<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Quang
  Date: 8/7/2024
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab 4 bài 5</title>
</head>
<body>
    <table border="1" style="width: 100%">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Amount</th>
            <th></th>
        </tr>
        <c:forEach var="item" items="${cart.items}">
            <form action="/cart/update/${item.id}">
                <input type="hidden" name="id" value="${item.id}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td><input type="text" name="qty" onblur="this.form.submit()" style="width: 50px">${item.qty}</td>
                    <td>${item.price*item.qty}</td>
                    <td>
                        <a href="/cart/remove/${item.id}">Remove</a>
                    </td>
                </tr>
            </form>
        </c:forEach>
    </table>
    <h5>Quality: ${quality}</h5>
    <h5>Sum: ${sum}</h5>

    <a href="/cart/clear">Clear cart</a>
    <a href="/item/index">Add more</a>
</body>
</html>
