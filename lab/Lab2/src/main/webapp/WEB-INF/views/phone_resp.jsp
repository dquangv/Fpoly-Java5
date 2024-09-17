<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phone</title>
</head>
<body>
	<h2>Smart phone</h2>
    <p><strong>Name:</strong> ${name}</p>
    <p><strong>Price:</strong> ${price}</p>
    <p><strong>Maker:</strong> ${maker}</p>
    <p><strong>Country:</strong> ${country}</p>
    <c:if test="${not empty uploadedImage}">
		<p><strong>Uploaded Image:</strong></p>
		<img src="/uploads/${uploadedImage}" alt="Uploaded Image" style="max-width: 100%;">
	</c:if>
	<a href="/smartphone" class="btn btn-primary mt-3">Back</a>
</body>
</html>