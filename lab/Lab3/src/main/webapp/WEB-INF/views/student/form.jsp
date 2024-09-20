<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Information Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .form-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
    .form-container .form-group input[type="radio"] {
        margin-right: 10px;
    }
    .form-container .form-group input[type="checkbox"] {
        margin-right: 10px;
        }
        .form-container .form-group label {
        margin-right: 10px;
    }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="form-container">
                    <h2 class="text-center mb-4">Student Information</h2>
                    <form:form action="${pageContext.request.contextPath}/student/save" method="post" modelAttribute="student">
                        <div class="form-group">
                            <form:label path="name">Name</form:label>
                            <form:input path="name" class="form-control"/>
                            <form:errors path="name" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <form:label path="email">Email</form:label>
                            <form:input path="email" class="form-control"/>
                            <form:errors path="email" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <form:label path="marks">Marks</form:label>
                            <form:input path="marks" class="form-control" type="number"/>
                            <form:errors path="marks" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <form:label path="gender">Gender</form:label>
                            <div>
                                <form:radiobuttons path="gender" items="${genders}" class="mr-2"/>
                            </div>
                            <form:errors path="gender" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <form:label path="hobbies">Hobbies</form:label>
                            <div>
                                <form:checkboxes path="hobbies" items="${hobbies}" class="mr-2"/>
                            </div>
                            <form:errors path="hobbies" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <form:label path="faculty">Faculty</form:label>
                            <form:select path="faculty" class="form-control">
                                <%-- <form:option value="" label="Select a faculty"/> --%>
                                <form:options items="${faculties}"/>
                            </form:select>
                            <form:errors path="faculty" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block">Save</button>
                        </div>
                    </form:form>
                    <c:if test="${not empty message}">
                        <div class="alert alert-success mt-3">${message}</div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
