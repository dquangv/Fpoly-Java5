<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
<title>Book</title>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-9">
				<h3>Book</h3>
			</div>
			<div class="col-3">
				<a href="/account/logout" class="btn btn-secondary">Logout</a>
			</div>
		</div>
		<hr>

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
		        <button type="submit" class="btn btn-primary">${book != null && book.id != null ? 'Update' : 'Create'}</button>
		        <c:if test="${book != null && book.id != null}">
		            <a href="/book/delete/${book.id}" class="btn btn-danger">Delete</a>
		        </c:if>
		        <a href="/book/index" class="btn btn-secondary">Reset</a>
		    </div>
		</form:form>
	</div>
</body>
</html>
