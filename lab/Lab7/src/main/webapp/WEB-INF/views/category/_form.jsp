<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/category/index" modelAttribute="item"
	class="form-control">
	<div class="row">
		<div class="col-6">
			<form:input path="id" placeholder="Category Id?" class="form-control" />
		</div>
		<div class="col-6">
			<form:input path="name" placeholder="Category Name?"
				class="form-control" />
		</div>
	</div>
	<hr>
	<div>
		<button formaction="/category/create" class="btn btn-primary">Create</button>
		<button formaction="/category/update" class="btn btn-success">Update</button>
		<a href="/category/delete/${item.id}" class="btn btn-danger">Delete</a>
		<a href="/category/index" class="btn btn-secondary">Reset</a>
	</div>
</form:form>
