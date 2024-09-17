<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Verify OTP</title>
    <link href="../css/verify-otp.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container height-100 d-flex justify-content-center align-items-center w-50 mt-5">
    <div class="position-relative">
        <div class="card p-2 text-center">
            <h6>Vui lòng nhập mã OTP<br> đã được gửi đến địa chỉ email của bạn</h6>
<%--            <div><span>A code has been sent to</span> <small>*******9897</small></div>--%>
            <form method="post" action="/verify-otp">
                <div id="otp" class="inputs d-flex flex-row justify-content-center mt-2">
                    <input class="m-2 text-center form-control rounded" type="text" id="first" maxlength="1"/>
                    <input class="m-2 text-center form-control rounded" type="text" id="second" maxlength="1"/>
                    <input class="m-2 text-center form-control rounded" type="text" id="third" maxlength="1"/>
                    <input class="m-2 text-center form-control rounded" type="text" id="fourth" maxlength="1"/>
                    <input class="m-2 text-center form-control rounded" type="text" id="fifth" maxlength="1"/>
                    <input class="m-2 text-center form-control rounded" type="text" id="sixth" maxlength="1"/>
                </div>
                <input type="hidden" name="otp" id="otpInput">
                <div class="mt-4">
                    <button type="submit" class="btn btn-danger px-4 validate">Xác nhận</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function(event) {
        function OTPInput() {
            const inputs = document.querySelectorAll('#otp > *[id]');
            const otpInput = document.getElementById('otpInput');

            for (let i = 0; i < inputs.length; i++) {
                inputs[i].addEventListener('input', function(event) {
                    // Move to next input if current input is filled
                    if (this.value.length === this.maxLength) {
                        if (i !== inputs.length - 1) inputs[i + 1].focus();
                    }
                    // Update otpInput with the concatenated values
                    otpInput.value = Array.from(inputs).map(input => input.value).join('');
                });

                inputs[i].addEventListener('keydown', function(event) {
                    // Handle backspace key to focus previous input
                    if (event.key === "Backspace" && this.value.length === 0) {
                        if (i !== 0) inputs[i - 1].focus();
                    }
                });
            }
        }
        OTPInput();
    });
</script>
</body>
</html>
