<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form:form action="${book != null && book.id != null ? '/book/update' : '/book/create'}" modelAttribute="book" enctype="multipart/form-data" class="form-control lh-lg">


    <div class="form-group">
        <label class="form-group">Title:</label>
        <form:input path="title" class="form-control" placeholder="Enter title" required="true" />
    </div>

    <div class="form-group">
        <label class="form-group">Author:</label>
        <form:input path="author" class="form-control" placeholder="Enter author" required="true" />
    </div>

    <div class="form-group">
        <label class="form-group">Price:</label>
        <form:input path="price" class="form-control" placeholder="Enter price" required="true" />
    </div>

    <div class="form-group">
        <label class="form-group">Time Published:</label>
        <form:input path="timePublished" type="datetime-local" class="form-control" required="true" />
    </div>

    <hr>
    <div>
        <button type="submit" class="btn btn-primary">${book.id != null ? 'Update' : 'Create'}</button>
        <c:if test="${book.id != null}">
            <a href="/book/delete/${book.id}" class="btn btn-danger">Delete</a>
        </c:if>
        <a href="/book/index" class="btn btn-secondary">Reset</a>
    </div>
</form:form>
