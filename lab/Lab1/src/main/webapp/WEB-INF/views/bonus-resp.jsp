<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bonus Response</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="margin: 50px auto; width: 30%">
    <h2>Bonus Response</h2>
    <p><strong>Message:</strong> ${message}</p>
    <p><strong>Session Attribute:</strong> ${sessionAttr}</p>
    <p><strong>Application:</strong> ${application}</p>
    <c:if test="${not empty uploadedImage}">
		<p><strong>Uploaded Image:</strong></p>
		<img src="/uploads/${uploadedImage}" alt="Uploaded Image" style="max-width: 100%;">
	</c:if>
	<a href="/bonus" class="btn btn-primary mt-3">Back</a>
</body>
</html>
