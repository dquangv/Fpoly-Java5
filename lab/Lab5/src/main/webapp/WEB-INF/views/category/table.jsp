<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">
		<h2>Category List</h2>
		<table class="table table-bordered table-striped">
			<!-- <thead>
				<tr>
					<th><a href="/category/index?field=id">Id</a></th>
					<th><a href="/category/index?field=name">Name</a></th>
					<th>Actions</th>
				</tr>
			</thead> -->
			<thead>
    <tr>
        <th><a href="/category/index?field=id&sortDir=${currentSortDir == 'asc' ? 'desc' : 'asc'}">Id</a></th>
        <th><a href="/category/index?field=name&sortDir=${currentSortDir == 'asc' ? 'desc' : 'asc'}">Name</a></th>
        <th>Actions</th>
    </tr>
</thead>
			
			<tbody>
				<c:forEach var="item" items="${page.content}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td><a href="/category/edit/${item.id}" class="btn btn-primary">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<%-- <nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link"
					href="/category/index?page=0">|&lt;First</a></li>
				<li class="page-item"><a class="page-link"
					href="/category/index?page=${page.number==0?0:page.number-1}">&lt;&lt;Previous</a></li>
				<li class="page-item"><a class="page-link"
					href="/category/index?page=${page.number==page.totalPages-1?page.totalPages-1:page.number+1}">Next&gt;&gt;</a></li>
				<li class="page-item"><a class="page-link"
					href="/category/index?page=${page.totalPages-1}">Last&gt;|</a></li>
			</ul>
		</nav> --%>
		
		<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="/category/index?page=0&field=${currentSortField}&sortDir=${currentSortDir}">|&lt;First</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="/category/index?page=${page.number==0?0:page.number-1}&field=${currentSortField}&sortDir=${currentSortDir}">&lt;&lt;Previous</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="/category/index?page=${page.number==page.totalPages-1?page.totalPages-1:page.number+1}&field=${currentSortField}&sortDir=${currentSortDir}">Next&gt;&gt;</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="/category/index?page=${page.totalPages-1}&field=${currentSortField}&sortDir=${currentSortDir}">Last&gt;|</a>
        </li>
    </ul>
</nav>
		
		
		<div class="row">
			<div class="col-md-12">
				<ul class="list-group">
					<li class="list-group-item">Current Entities: ${page.numberOfElements}</li>
					<li class="list-group-item">Page Number: ${page.number+1}</li>
					<li class="list-group-item">Page Size: ${page.size}</li>
					<li class="list-group-item">Total Entities: ${page.totalElements}</li>
					<li class="list-group-item">Total Pages: ${page.totalPages}</li>
				</ul>
			</div>
		</div>
	</div>