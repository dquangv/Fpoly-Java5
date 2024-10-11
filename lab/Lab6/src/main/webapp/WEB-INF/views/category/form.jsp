	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/category/create" modelAttribute="item" class="form-horizontal">
    <div class="form-group">
        <label for="id" class="col-sm-2 control-label">Category Id</label>
        <div class="col-sm-10">
            <form:input path="id" placeholder="Category Id" class="form-control"/>
            <form:errors path="id" cssClass="text-danger"/> 
        </div>
    </div>
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Category Name</label>
        <div class="col-sm-10">
            <form:input path="name" placeholder="Category Name" class="form-control"/>
            <form:errors path="name" cssClass="text-danger"/> 
        </div>
    </div>
    <hr>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button formaction="/category/create" class="btn btn-primary">Create</button>
            <button formaction="/category/update" class="btn btn-success">Update</button>
            <a href="/category/delete/${item.id}" class="btn btn-danger">Delete</a>
            <a href="/category/index" class="btn btn-info">Reset</a>
            <a href="/product/index" class="btn btn-warning">Manage Products</a>
        </div>
    </div>
</form:form>
