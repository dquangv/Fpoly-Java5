<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Triangle</title>
</head>
<body>
	<form action="/triangle" method="post">
		<p>a</p>
		<input type="number" class="form-control" id="a" name="a">
		<p>b</p>
		<input type="number" class="form-control" id="b" name="b">
		<p>c</p>
		<input type="number" class="form-control" id="c" name="c">
		<br>
		<button type="submit" class="btn btn-primary">Kiểm tra</button>
		<p class="mt-2 text-danger">${result}</p>
	</form>
</body>
</html>