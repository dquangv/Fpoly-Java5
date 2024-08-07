<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Lab 3</title>
</head>
<body>
<form:form action="/student/save" modelAttribute="sv" method="post">
    <form:input path="name" placeholder="Name" />
    <form:input path="email" placeholder="Email" />
    <form:input path="marks" placeholder="Marks" />

    <form:radiobuttons path="gender" items="${genders}" />

    <form:checkboxes path="hobbies" items="${hobbies}" />

    <form:select path="faculty" cssClass="form-control">
        <form:option value="" label="Select a faculty" />
        <form:options items="${faculties}" />
    </form:select>

    <button class="btn btn-default" type="submit">Save</button>

    ${message}
    <form:errors path="*" element="li" delimiter=";"/>
</form:form>
</body>
</html>
