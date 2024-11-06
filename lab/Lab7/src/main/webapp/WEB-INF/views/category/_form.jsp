<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/category/index" modelAttribute="item"
	class="form-control">
	<div class="row">
		<div class="col-6">
			<form:input path="id" placeholder="Id" class="form-control" />
		</div>
		<div class="col-6">
			<form:input path="name" placeholder="Tên loại sản phẩm"
				class="form-control" />
		</div>
	</div>
	<hr>
	<div>
		<button formaction="/category/create" class="btn btn-primary">Tạo</button>
		<button formaction="/category/update" class="btn btn-success">Sửa</button>
		<a href="/category/delete/${item.id}" class="btn btn-danger">Xoá</a>
		<a href="/category/index" class="btn btn-secondary">Làm mới</a>
	</div>
</form:form>
