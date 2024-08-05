<%--
  Created by IntelliJ IDEA.
  User: Quang
  Date: 7/11/2024
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab 2 Bài 3</title>
</head>
<body>
    <form action = "/product/save" method="post">
        <input name="name">
        <input name="price">
        <button>Save</button>
    </form>

    <ul>
        <li>${p.name}</li>
        <li>${p.price}</li>
    </ul>
</body>
</html>
