<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<table class="table table-bordered w-100">
	<tr>
		<th><a href="/category/index?field=id">Id</a></th>
		<th><a href="/category/index?field=name">Name</a></th>
		<th></th>
	</tr>
	<c:forEach var="item" items="${page.content}">
		<tr>
			<td>${item.id}</td>
			<td>${item.name}</td>
			<td><a href="/category/edit/${item.id}">Edit</a></td>
		</tr>
	</c:forEach>
</table>
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<li class="page-item"><a class="page-link"
			href="/category/index?page=0">|&lt;First</a></li>
		<li class="page-item"><a class="page-link"
			href="/category/index?page=${page.number-1}">&lt;&lt;Previous</a></li>
		<li class="page-item"><a class="page-link"
			href="/category/index?page=${page.number+1}">Next&gt;&gt;</a></li>
		<li class="page-item"><a class="page-link"
			href="/category/index?page=${page.totalPages-1}">Last&gt;|</a></li>
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