<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Quang
  Date: 8/7/2024
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab 4 bài 5</title>
</head>
<body>
    <ul>
        <c:forEach var="item" items="${items}">
            <li>
                ${item.name} (${item.price}) :: [<a href="/cart/add/${item.id}">Add To Cart</a>]
            </li>
        </c:forEach>
    </ul>
</body>
</html>
