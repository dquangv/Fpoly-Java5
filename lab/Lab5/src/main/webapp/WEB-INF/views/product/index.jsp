<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Management</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="text-center">Product Management</h1>

    <form:form modelAttribute="product" method="POST" action="${pageContext.request.contextPath}/product/create" class="form-horizontal">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name:</label>
            <div class="col-sm-10">
                <form:input path="name" placeholder="Product Name" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">Price:</label>
            <div class="col-sm-10">
                <form:input path="price" placeholder="Product Price" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="createDate" class="col-sm-2 control-label">Creation Date:</label>
            <div class="col-sm-10">
                <form:input path="createDate" placeholder="Product Creation Date" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="available" class="col-sm-2 control-label">Available:</label>
            <div class="col-sm-10">
                <form:checkbox path="available" class="form-control" style="display: inline;"/>
            </div>
        </div>
        <div class="form-group">
            <label for="category.id" class="col-sm-2 control-label">Category:</label>
            <div class="col-sm-10">
                <form:select path="category.id" class="form-control">
                    <form:options items="${cateList}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button formaction="/product/create" class="btn btn-primary">Create</button>
                <button formaction="/product/update" class="btn btn-success">Update</button>
                <a href="/product/delete/${product.id}" class="btn btn-danger">Delete</a>
                <a href="/product/index" class="btn btn-info">Reset</a>
                <a href="/category/index" class="btn btn-warning">Manage Categories</a>
            </div>
        </div>
    </form:form>

    <!-- Display product list -->
    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Creation Date</th>
                    <th>Available</th>
                    <th>Category</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.createDate}</td>
                        <td>${product.available}</td>
                        <td>${product.category.name}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/product/edit/${product.id}" class="btn btn-primary">Edit</a>
                            <a href="${pageContext.request.contextPath}/product/delete/${product.id}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>