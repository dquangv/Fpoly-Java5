<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <title>Lab 2 bài 4</title>
</head>
<body>
<div class="container" style="margin-top: 10px;">
    <div class="row"
         style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <h2>Thông tin Product</h2>
            <form action="/product/save2" method="post">
                <div class="form-group">
                    <label>Name:</label> <input type="text" class="form-control"
                                                name="name" value="" placeholder="Enter name">
                </div>
                <div class="form-group">
                    <label>Price</label> <input type="text" class="form-control"
                                                name="price" value="" placeholder="Enter price">
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
            <br>
            <div class="alert alert-success" role="alert">${message}</div>
        </div>
    </div>
</div>
<div class="container">
    <h2>List Get Product</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>NAME</th>
            <th>PRICE</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${product1.name}</td>
            <td>${product1.price}</td>
        </tr>
        </tbody>
    </table>
</div>
<div class="container">
    <h2>List Post Product</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>NAME</th>
            <th>PRICE</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
        </tr>
        </tbody>
    </table>
</div>
<div class="container">
    <h2>List Product</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>NAME</th>
            <th>PRICE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${products}">
            <tr>
                <td>${p.name}</td>
                <td>${p.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
