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
<title>Product Management Lab6</title>
</head>
<body class="container mt-3">
	<a href="/product/index">&lt; Main Page</a><br>
	<form action="/product/searchByPrice" method="post"
		class="form-control">
		<h4>Search by Price Range</h4>
		<div class="row">
			<div class="col-4">
				<input name="min" value="${param.min}" placeholder="Min Price?"
					class="form-control">
			</div>
			<div class="col-4">
				<input name="max" value="${param.max}" placeholder="Max Price?"
					class="form-control">
			</div>
			<div class="col-4">
				<button class="btn btn-primary">Search</button>
				<button class="btn btn-secondary" type="reset">Reset</button>
			</div>
		</div>
	</form>
	<form action="/product/searchByKeywords" method="post"
		class="form-control mt-3 mb-3">
		<h4>Search by Name</h4>
		<div class="row">
			<div class="col-6">
				<input name="keywords" value="${keywords}" placeholder="Keywords?"
					class="form-control">
			</div>
			<div class="col-6">
				<button class="btn btn-primary">Search</button>
				<button class="btn btn-secondary" type="reset">Reset</button>
			</div>
		</div>
	</form>
	<table class="table table-bordered w-100">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Create Date</th>
		</tr>
		<c:forEach var="product" items="${page.content}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.createDate}</td>
			</tr>
		</c:forEach>
	</table>
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link"
				href="/product/searchByPrice?page=0">|&lt;First</a></li>
			<li class="page-item"><a class="page-link"
				href="/product/searchByPrice?page=${page.number==0?0:page.number-1}">&lt;&lt;Previous</a></li>
			<li class="page-item"><a class="page-link"
				href="/product/searchByPrice?page=${page.number==page.totalPages-1?page.totalPages-1:page.number+1}">Next&gt;&gt;</a></li>
			<li class="page-item"><a class="page-link"
				href="/product/searchByPrice?page=${page.totalPages-1}">Last&gt;|</a></li>
		</ul>
	</nav>
	<ul class="list-group">
		<li class="list-group-item">Số thực thể hiện tại:
			${page.numberOfElements}</li>
		<li class="list-group-item">Trang số: ${page.number+1}</li>
		<li class="list-group-item">Kích thước trang: ${page.size}</li>
		<li class="list-group-item">Tổng số thực thể:
			${page.totalElements}</li>
		<li class="list-group-item">Tổng số trang: ${page.totalPages}</li>
	</ul>
</body>
</html>


