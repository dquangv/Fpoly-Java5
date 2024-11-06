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
        <th>Title</th> <!-- Đổi tên cột từ "Name" thành "Title" -->
        <th>Author</th> <!-- Thêm cột cho tác giả -->
        <th>Price</th>
        <th>Time Published</th> <!-- Thay đổi cột để phù hợp với thuộc tính -->
    </tr>
    <c:forEach var="book" items="${book}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td> <!-- Sử dụng thuộc tính title -->
            <td>${book.author}</td> <!-- Sử dụng thuộc tính author -->
            <td>${book.price}</td> <!-- Sử dụng thuộc tính price -->
            <td>${book.timePublished}</td> <!-- Sử dụng thuộc tính timePublished -->
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