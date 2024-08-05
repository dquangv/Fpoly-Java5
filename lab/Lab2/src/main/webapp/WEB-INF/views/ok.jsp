<%--
  Created by IntelliJ IDEA.
  User: Quang
  Date: 7/10/2024
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab 2 Bài 1</title>
</head>
<body>
    <form action="/ctrl/ok" method="post">
        <button>OK 1</button>
        <button formmethod="get">OK 2</button>
        <button formaction="/ctrl/ok/x">OK 3</button>
    </form>
    Kết quả: ${message}
</body>
</html>
