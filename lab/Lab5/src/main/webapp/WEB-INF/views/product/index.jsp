<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list</title>
</head>
<body>
<h1>Product List</h1>
<%-- <table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Image</th>
        <th>Price</th>
        <th>Create Date</th>
        <th>Available</th>
        <th>Category</th>
        <th>Order Details</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.image}</td>
            <td>${product.price}</td>
            <td>${product.createDate}</td>
            <td>${product.available}</td>
            <td>${product.category.name}</td>
            <td>
                <c:forEach items="${product.orderDetails}" var="orderDetail">
                    ${orderDetail.id}
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table> --%>
</body>
</html>