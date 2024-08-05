<%--
  Created by IntelliJ IDEA.
  User: Quang
  Date: 7/10/2024
  Time: 12:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab 2 Bài 2</title>
</head>
<body>
    <form action="/param/save/2021" method="post">
        <input name="y" value="2031">
        <button>Save</button>
    </form>
    <ul>
        <li>${x}</li>
        <li>${y}</li>
    </ul>
</body>
</html>
