<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .table-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-10">
                <div class="table-container">
                    <h2 class="text-center mb-4">Student List</h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Marks</th>
                                <th>Gender</th>
                                <th>Hobbies</th>
                                <th>Faculty</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="student" items="${students}">
                                <tr>
                                    <td><c:out value="${student.name}"/></td>
                                    <td><c:out value="${student.email}"/></td>
                                    <td><c:out value="${student.marks}"/></td>
                                    <td><c:out value="${student.gender}"/></td>
                                    <td><c:forEach var="hobby" items="${student.hobbies}">
                                            <c:out value="${hobby}"/><br/>
                                        </c:forEach>
                                    </td>
                                    <td><c:out value="${student.faculty}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="text-center mt-4">
                        <a href="${pageContext.request.contextPath}/student/form" class="btn btn-primary">Add New Student</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
