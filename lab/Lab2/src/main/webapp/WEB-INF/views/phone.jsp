<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phone</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<form action="/smartphone_detail" method="post" enctype="multipart/form-data">
		<h1>Smart Phone</h1>
		<div class="mb-3">
			<label for="name" class="form-label">Name</label> 
			<input type="text" class="form-control" id="name" name="name">
		</div>
		<div class="mb-3">
			<label for="price" class="form-label">Price</label> 
			<input type="number" class="form-control" id="price" name="price">
		</div>
		<div class="mb-3">
			<label for="maker" class="form-label">Maker</label> 
			<select class="form-select" aria-label="Default select example" name="maker">
				<option selected value="Samsung">Samsung</option>
				<option value="Apple">Apple</option>
				<option value="Sonny">Sonny</option>
			</select>
		</div>
		<div class="mb-3">
			<label for="country" class="form-label">Country</label> 
			<select class="form-select" aria-label="Default select example" name="country">
				<option selected value="Vietnam">Vietnam</option>
				<option value="USA">USA</option>
				<option value="Japan">Japan</option>
			</select>
		</div>
		<div class="mb-3">
			<label for="image" class="form-label">Upload Image</label> 
			<input type="file" class="form-control" id="image" name="image" accept="image/*">
		</div>
		<button type="submit" class="btn btn-primary">Add</button>
		<p class="mt-2 text-danger">${loginMessage}</p>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>