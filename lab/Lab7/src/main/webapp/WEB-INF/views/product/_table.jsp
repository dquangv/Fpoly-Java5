<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="/product/searchByPrice" method="post" class="form-control">
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
			href="/product/index?page=0">|&lt;First</a></li>
		<li class="page-item"><a class="page-link"
			href="/product/index?page=${page.number==0?0:page.number-1}">&lt;&lt;Previous</a></li>
		<li class="page-item"><a class="page-link"
			href="/product/index?page=${page.number==page.totalPages-1?page.totalPages-1:page.number+1}">Next&gt;&gt;</a></li>
		<li class="page-item"><a class="page-link"
			href="/product/index?page=${page.totalPages-1}">Last&gt;|</a></li>
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