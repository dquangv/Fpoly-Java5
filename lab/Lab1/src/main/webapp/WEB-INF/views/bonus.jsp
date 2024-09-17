<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bonus</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body style="margin: 50px auto; width: 30%">
	<form action="/process" method="post" enctype="multipart/form-data">
		<div class="mb-3">
			<label for="message" class="form-label">Message</label> 
			<input type="text" class="form-control" id="message" name="message">
		</div>
		<div class="mb-3">
			<label for="session" class="form-label">Session Attribute</label> 
			<input type="text" class="form-control" id="session" name="session">
		</div>
		<div class="mb-3">
			<label for="application" class="form-label">Application</label> 
			<select class="form-select" aria-label="Default select example" name="application">
				<option selected value="Vietnam">Vietnam</option>
				<option value="US">US</option>
				<option value="Roma">Roma</option>
				<option value="Singapore">Singapore</option>
			</select>
		</div>
		<div class="mb-3">
			<label for="image" class="form-label">Upload Image</label> 
			<input type="file" class="form-control" id="image" name="image" accept="image/*">
		</div>
		<button type="submit" class="btn btn-primary">Send</button>
		<p class="mt-2 text-danger">${loginMessage}</p>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
