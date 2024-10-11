<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/product/index" modelAttribute="product"
	enctype="multipart/form-data" class="form-control lh-lg">

	<div class="form-group">
		<label class="form-group">Name:</label>
		<form:input path="name" class="form-control" placeholder="Enter name" />
	</div>
	<div class="form-group">
		<label class="form-group">Price:</label>
		<form:input path="price" class="form-control"
			placeholder="Enter price" />
	</div>
	<div class="form-group">
		<label class="form-group">Image:</label> <input name="attach"
			type="file" class="form-control">
	</div>
	<div class="row">
		<div class="col 6">
			<div class="w-25">
				<label class="form-group">Create Date:</label> <input
					name="createDate" type="date" class="form-control"
					value="2024-01-24">
			</div>
		</div>
		<div class="col 6">
			<div class="form-group">
				<label class="form-group">Status:</label><br>
				<form:radiobutton path="available" value="true" label="Available"
					class="form-check-inline me-2"/>
				<form:radiobutton path="available" value="false" label="Unavailable"
					class="form-check-inline ms-5 me-2"/>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label class="form-group">Category:</label>
		<form:select path="category.id" class="form-select">
			<form:options items="${cateList}" itemValue="id" itemLabel="name" />
		</form:select>

	</div>
	<hr>
	<div>
		<button formaction="/product/create" class="btn btn-primary">Create</button>
		<button formaction="/product/update" class="btn btn-success">Update</button>
		<a href="/product/delete/${product.id}" class="btn btn-danger">Delete</a>
		<a href="/product/index" class="btn btn-secondary">Reset</a>
	</div>
</form:form>