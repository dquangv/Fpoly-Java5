<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<title>Send Mail Lab7</title>
</head>
<body class="container mt-3 w-50">
	<nav class="navbar bg-success" data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand fw-bold" href="">Java 5 Lab 7</a>
			<span class="fw-bold fs-3 text-white">Demo Send Mail</span>
		</div>
	</nav>
	<form enctype="multipart/form-data" class="form-control"
		action="/mail/send" method="post">
		<h2 class="fst-italic">Soạn email mới</h2>
		<div class="form-group">
			<label for="formControlInput">To</label> <input type="email"
				class="form-control" id="formControlInput" name="To"
				placeholder="Nhập email người nhận...">
		</div>
		<div class="form-group">
			<label for="formControlInput2">CC</label> <input type="text"
				class="form-control" id="formControlInput2" name="CC"
				placeholder="Nhập email(cc) ngăn cách nhau bởi dấu ','">
		</div>
		<div class="form-group">
			<label for="formControlInput3">BCC</label> <input type="text"
				class="form-control" id="formControlInput3" name="BCC"
				placeholder="Nhập email(bcc) ngăn cách nhau bởi dấu ','">
		</div>
		<div class="form-group">
			<label for="formControlInput4">Tiêu đề</label> <input type="text"
				class="form-control" id="formControlInput4" name="Subject"
				placeholder="Nhập tiêu đề...">
		</div>
		<div class="form-group">
			<label for="formControlTextarea">Nội dung</label>
			<textarea class="form-control" id="formControlTextarea"
				name="Content" rows="4" placeholder="Nhập nội dung..."></textarea>
		</div>
		<div class="form-group">
			<label for="formControlInput4">File đính kèm</label> <input
				type="file" class="form-control" id="formControlInput4" name="file">
		</div>
		<br />
		<button class="btn btn-success">Gửi</button>
	</form>
	<%-- <div class="badge text-bg-success">
		${message}
	</div> --%>
</body>
</html>