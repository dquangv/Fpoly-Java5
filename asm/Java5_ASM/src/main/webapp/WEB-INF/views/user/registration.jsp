<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <link href="../css/registration.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <%--    <style>--%>
    <%--        /* CSS styles for the registration form container */--%>
    <%--        .registration-container {--%>
    <%--            width: 600px; /* Set the width of the container */--%>
    <%--            margin: 0 auto; /* Center the container horizontally */--%>
    <%--            padding: 20px; /* Add some padding inside the container */--%>
    <%--            border: 2px solid #ccc; /* Add a border */--%>
    <%--            border-radius: 10px; /* Add some border radius */--%>
    <%--            background-color: #f9f9f9; /* Background color */--%>
    <%--        }--%>

    <%--        /* CSS styles for the heading */--%>
    <%--        .registration-heading {--%>
    <%--            text-align: center; /* Center the heading text */--%>
    <%--        }--%>

    <%--        /* CSS styles for input fields */--%>
    <%--        .input-field {--%>
    <%--            width: 100%;--%>
    <%--            padding: 8px;--%>
    <%--            margin: 5px 0;--%>
    <%--            box-sizing: border-box;--%>
    <%--        }--%>
    <%--    </style>--%>
</head>
<body>

<section class="h-100 bg-dark">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card card-registration my-4">
                    <div class="row g-0">
                        <div class="col-xl-6 d-none d-xl-block">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
                                 alt="Sample photo" class="img-fluid"
                                 style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;"/>
                        </div>
                        <div class="col-xl-6">
                            <div class="card-body p-md-5 text-black">
                                <h3 class="mb-5 text-uppercase">Đăng ký tài khoản</h3>
                                <form action="/signup" method="post">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="fullname" placeholder="Họ và tên">
                                        <label for="fullname">Họ và tên</label>
                                    </div>

                                    <%--                                <div class="row">--%>
                                    <%--                                    <div class="col-md-6 mb-4">--%>
                                    <%--                                        <div data-mdb-input-init class="form-outline">--%>
                                    <%--                                            <input type="text" id="form3Example1m1"--%>
                                    <%--                                                   class="form-control form-control-lg"/>--%>
                                    <%--                                            <label class="form-label" for="form3Example1m1">Mother's name</label>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>
                                    <%--                                    <div class="col-md-6 mb-4">--%>
                                    <%--                                        <div data-mdb-input-init class="form-outline">--%>
                                    <%--                                            <input type="text" id="form3Example1n1"--%>
                                    <%--                                                   class="form-control form-control-lg"/>--%>
                                    <%--                                            <label class="form-label" for="form3Example1n1">Father's name</label>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>
                                    <%--                                </div>--%>

                                    <div class="form-floating mb-3">
                                        <input type="email" class="form-control" id="floatingInput"
                                               placeholder="name@example.com" name="email">
                                        <label for="floatingInput">Email</label>
                                    </div>

                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" id="floatingPassword"
                                               placeholder="Password" name="password">
                                        <label for="floatingPassword">Mật khẩu</label>
                                    </div>

                                    <div class="d-md-flex justify-content-start align-items-center mb-3 py-2">

                                        <h6 class="mb-0 me-4">Gender: </h6>

                                        <div class="form-check form-check-inline mb-0 me-4">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                                   id="femaleGender"
                                                   value="option1"/>
                                            <label class="form-check-label" for="femaleGender">Female</label>
                                        </div>

                                        <div class="form-check form-check-inline mb-0 me-4">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                                   id="maleGender"
                                                   value="option2"/>
                                            <label class="form-check-label" for="maleGender">Male</label>
                                        </div>
                                    </div>

                                    <div class="form-floating mb-3">
                                        <input type="number" class="form-control" id="floatingPhone"
                                               placeholder="Phone number"
                                               inputmode="numeric" pattern="[0-9]*" maxlength="10">
                                        <label for="floatingPhone">Số điện thoại</label>
                                    </div>

                                    <div class="form-floating">
                                        <textarea class="form-control" placeholder="Address"
                                                  id="floatingTextarea"></textarea>
                                        <label for="floatingTextarea">Địa chỉ</label>
                                    </div>

                                    <%--                                <div data-mdb-input-init class="form-outline mb-4">--%>
                                    <%--                                    <input type="text" id="form3Example8" class="form-control form-control-lg"/>--%>
                                    <%--                                    <label class="form-label" for="form3Example8">Address</label>--%>
                                    <%--                                </div>--%>

                                    <%--                                --%>

                                    <%--                                <div class="row">--%>
                                    <%--                                    <div class="col-md-6 mb-4">--%>

                                    <%--                                        <select data-mdb-select-init>--%>
                                    <%--                                            <option value="1">State</option>--%>
                                    <%--                                            <option value="2">Option 1</option>--%>
                                    <%--                                            <option value="3">Option 2</option>--%>
                                    <%--                                            <option value="4">Option 3</option>--%>
                                    <%--                                        </select>--%>

                                    <%--                                    </div>--%>
                                    <%--                                    <div class="col-md-6 mb-4">--%>

                                    <%--                                        <select data-mdb-select-init>--%>
                                    <%--                                            <option value="1">City</option>--%>
                                    <%--                                            <option value="2">Option 1</option>--%>
                                    <%--                                            <option value="3">Option 2</option>--%>
                                    <%--                                            <option value="4">Option 3</option>--%>
                                    <%--                                        </select>--%>

                                    <%--                                    </div>--%>
                                    <%--                                </div>--%>

                                    <%--                                <div data-mdb-input-init class="form-outline mb-4">--%>
                                    <%--                                    <input type="text" id="form3Example9" class="form-control form-control-lg"/>--%>
                                    <%--                                    <label class="form-label" for="form3Example9">DOB</label>--%>
                                    <%--                                </div>--%>

                                    <%--                                <div data-mdb-input-init class="form-outline mb-4">--%>
                                    <%--                                    <input type="text" id="form3Example90" class="form-control form-control-lg"/>--%>
                                    <%--                                    <label class="form-label" for="form3Example90">Pincode</label>--%>
                                    <%--                                </div>--%>

                                    <%--                                <div data-mdb-input-init class="form-outline mb-4">--%>
                                    <%--                                    <input type="text" id="form3Example99" class="form-control form-control-lg"/>--%>
                                    <%--                                    <label class="form-label" for="form3Example99">Course</label>--%>
                                    <%--                                </div>--%>

                                    <%--                                <div data-mdb-input-init class="form-outline mb-4">--%>
                                    <%--                                    <input type="text" id="form3Example97" class="form-control form-control-lg"/>--%>
                                    <%--                                    <label class="form-label" for="form3Example97">Email ID</label>--%>
                                    <%--                                </div>--%>

                                    <div class="d-flex justify-content-end pt-3">
                                        <button type="submit" data-mdb-button-init data-mdb-ripple-init
                                                class="btn btn-warning btn-lg ms-2">Đăng ký
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
