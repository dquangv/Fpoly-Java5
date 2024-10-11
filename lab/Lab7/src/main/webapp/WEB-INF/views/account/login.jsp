<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<title>Login</title>
<style>
/* Thêm các tùy chỉnh CSS của bạn dưới đây */
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

.h-custom {
	height: calc(100% - 73px);
}

@media ( max-width : 450px) {
	.h-custom {
		height: 100%;
	}
}
</style>
</head>
<body>
	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-9 col-lg-6 col-xl-5">
					<img
						src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
						class="img-fluid" alt="Sample image">
				</div>
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
					<form action="/account/login" method="post">
						<!-- Email input -->
						<div class="form-outline mb-4">
							<label class="form-label fw-bold" for="form3Example3">Username</label>
							<input type="text" id="form3Example3"
								class="form-control form-control-lg"
								placeholder="Enter a valid email address" name="username" />
						</div>

						<!-- Password input -->
						<div class="form-outline mb-3">
							<label class="form-label fw-bold" for="form3Example4">Password</label>
							<input type="password" id="form3Example4"
								class="form-control form-control-lg"
								placeholder="Enter password" name="password" />
						</div>

						<div class="d-flex justify-content-between align-items-center mb-3">
							<!-- Checkbox -->
							<div class="form-check mb-0">
								<input class="form-check-input me-2" type="checkbox" value=""
									id="form2Example3" name="remember" /> <label
									class="form-check-label" for="form2Example3"> Remember
									me? </label>
							</div>
							<a href="#!" class="text-body">Forgot password?</a>
						</div>
						
						<div class="text-danger">
							<b><i>${message}</i></b>
						</div>
						
						<div class="text-center text-lg-start mt-4 pt-2">
							<button type="submit" class="btn btn-primary btn-lg"
								style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
							<p class="small fw-bold mt-2 pt-1 mb-0">
								Don't have an account? <a href="#!" class="link-danger">Register</a>
							</p>
						</div>
	
					</form>
				</div>
			</div>
		</div>
		<div
			class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
			<!-- Copyright -->
			<div class="text-white mb-3 mb-md-0">Copyright © 2024. All
				rights reserved.</div>
			<!-- Copyright -->
		</div>
	</section>
</body>
</html>