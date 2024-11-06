<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Doctor</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                crossorigin="anonymous">
            <style>
                table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-top: 20px;
                }

                th,
                td {
                    border: 1px solid #ddd;
                    padding: 10px;
                    text-align: left;
                }

                th {
                    background-color: #f0f0f0;
                }

                .form-container {
                    width: 50%;
                    margin: 40px auto;
                    padding: 20px;
                    background-color: #f9f9f9;
                    border: 1px solid #ccc;
                    border-radius: 10px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                }

                .form-label {
                    display: block;
                    margin-bottom: 10px;
                }

                .form-input,
                .form-select {
                    width: 100%;
                    height: 40px;
                    margin-bottom: 20px;
                    padding: 10px;
                    border: 1px solid #ccc;
                    border-radius: 5px;
                    box-sizing: border-box;
                    /* Ensures the input and select fields do not overflow the form container */
                }

                .form-button {
                    width: 45%;
                    height: 40px;
                    background-color: #4CAF50;
                    color: #fff;
                    padding: 10px;
                    border: none;
                    border-radius: 5px;
                    cursor: pointer;
                    display: inline-block;
                    margin-right: 10px;
                }

                .form-button:hover {
                    background-color: #3e8e41;
                }

                h1 {
                    text-align: center;
                }

                /* Added style for logout button */
                .logout-button {
                    position: absolute;
                    top: 10px;
                    right: 10px;
                    background-color: #4CAF50;
                    color: #fff;
                    padding: 10px;
                    border: none;
                    border-radius: 5px;
                    cursor: pointer;
                    display: inline-block;
                }

                .logout-button:hover {
                    background-color: #3e8e41;
                }
            </style>
        </head>

        <body>
            <div style="position: relative;">
                <button class="logout-button"
                    onclick="location.href='${pageContext.request.contextPath}/logout'">Logout</button>

            </div>
            <h1>Doctor</h1>
            <!-- <div class="form-container">
                <form action="${pageContext.request.contextPath}/books/saveOrUpdate" method="post">
                    <input type="hidden" name="id" value="${book.id}">

                    <div class="form-label">Title:</div>
                    <input type="text" name="title" value="${book.title}" required class="form-input"><br>

                    <div class="form-label">Author:</div>
                    <input type="text" name="author" value="${book.author}" required class="form-input"><br>

                    <div class="form-label">Price:</div>
                    <input type="number" name="price" value="${book.price}" required class="form-input"><br>

                    <div class="form-label">Time Published:</div>
                    <input type="datetime-local" name="timePublished" value="${book.timePublished}" required
                        class="form-input"><br>

                    <div class="form-label">Genre:</div>
                    <select name="genre" required class="form-select">
                        <option value="FICTION" <c:if test="${book.genre == 'FICTION'}">selected</c:if>>Fiction</option>
                        <option value="NON_FICTION" <c:if test="${book.genre == 'NON_FICTION'}">selected</c:if>
                            >Non-Fiction</option>
                        <option value="MYSTERY" <c:if test="${book.genre == 'MYSTERY'}">selected</c:if>>Mystery</option>
                        <option value="FANTASY" <c:if test="${book.genre == 'FANTASY'}">selected</c:if>>Fantasy</option>
                        <option value="SCIFI" <c:if test="${book.genre == 'SCIFI'}">selected</c:if>>Sci-Fi</option>
                        <option value="BIOGRAPHY" <c:if test="${book.genre == 'BIOGRAPHY'}">selected</c:if>>Biography
                        </option>
                        <option value="HISTORY" <c:if test="${book.genre == 'HISTORY'}">selected</c:if>>History</option>
                        <option value="SELF_HELP" <c:if test="${book.genre == 'SELF_HELP'}">selected</c:if>>Self-Help
                        </option>
                        <option value="POETRY" <c:if test="${book.genre == 'POETRY'}">selected</c:if>>Poetry</option>
                        <option value="OTHER" <c:if test="${book.genre == 'OTHER'}">selected</c:if>>Other</option>
                    </select><br>

                    <div style="display: flex; align-items: center;">
                        <button type="submit" name="action" value="${action}"
                            class="btn btn-primary me-2">Submit</button>
                        <button type="submit" name="action" value="reset" class="btn btn-secondary"
                            formaction="${pageContext.request.contextPath}/books/reset">Reset</button>
                        <span style="margin-left: 10px; color: red;">${action}</span>
                    </div>
                </form>
            </div> -->
            <div class="form-container">
                <form action="${pageContext.request.contextPath}/doctors/saveOrUpdate" method="post">
                    <input type="hidden" name="id" value="${doctor.id}">
            
                    <div class="form-label">Firstname:</div>
                    <input type="text" name="firstName" value="${doctor.firstName}" class="form-input">
                    <c:if test="${not empty errorMessages['firstName']}">
                        <span style="color: red;">${errorMessages['firstName']}</span>
                    </c:if>
                    <br>
            
                    <div class="form-label">Lastname:</div>
                    <input type="text" name="lastName" value="${doctor.lastName}" class="form-input">
                    <c:if test="${not empty errorMessages['lastName']}">
                        <span style="color: red;">${errorMessages['lastName']}</span>
                    </c:if>
                    <br>
            
                    <div class="form-label">Salary:</div>
                    <input type="number" name="salary" value="${doctor.salary}" class="form-input">
                    <c:if test="${not empty errorMessages['salary']}">
                        <span style="color: red;">${errorMessages['salary']}</span>
                    </c:if>
                    <br>
            
                    <div class="form-label">Hire Date:</div>
                    <input type="datetime-local" name="hireDate" value="${book.hireDate}" class="form-input">
                    <c:if test="${not empty errorMessages['hireDate']}">
                        <span style="color: red;">${errorMessages['hireDate']}</span>
                    </c:if>
                    <br>
            
                    <%-- <div class="form-label">Genre:</div>
                    <select name="genre" class="form-select">
                        <option value="FICTION" <c:if test="${book.genre == 'FICTION'}">selected</c:if>>Fiction</option>
                        <option value="NON_FICTION" <c:if test="${book.genre == 'NON_FICTION'}">selected</c:if>>Non-Fiction</option>
                        <option value="MYSTERY" <c:if test="${book.genre == 'MYSTERY'}">selected</c:if>>Mystery</option>
                        <option value="FANTASY" <c:if test="${book.genre == 'FANTASY'}">selected</c:if>>Fantasy</option>
                        <option value="SCIFI" <c:if test="${book.genre == 'SCIFI'}">selected</c:if>>Sci-Fi</option>
                        <option value="BIOGRAPHY" <c:if test="${book.genre == 'BIOGRAPHY'}">selected</c:if>>Biography</option>
                        <option value="HISTORY" <c:if test="${book.genre == 'HISTORY'}">selected</c:if>>History</option>
                        <option value="SELF_HELP" <c:if test="${book.genre == 'SELF_HELP'}">selected</c:if>>Self-Help</option>
                        <option value="POETRY" <c:if test="${book.genre == 'POETRY'}">selected</c:if>>Poetry</option>
                        <option value="OTHER" <c:if test="${book.genre == 'OTHER'}">selected</c:if>>Other</option>
                    </select>
                    <c:if test="${not empty errorMessages['genre']}">
                        <span style="color: red;">${errorMessages['genre']}</span>
                    </c:if> --%>
                    <br>
            
                    <div style="display: flex; align-items: center;">
                        <button type="submit" name="action" value="${action}" class="btn btn-primary me-2">Submit</button>
                        <button type="submit" name="action" value="reset" class="btn btn-secondary" formaction="${pageContext.request.contextPath}/doctors/reset">Reset</button>
                        <span style="margin-left: 10px; color: green;">${action}</span>
                    </div>
                </form>
            </div>
            
            <h2>Search and Filter</h2>
            <form action="${pageContext.request.contextPath}/doctors/search" method="get">
                <div class="form-label">Search:</div>
                <input type="text" name="search" class="form-input" value="${param.search}">

                <!-- <div class="form-label">Filter by Genre:</div> -->
                <!-- <select name="filter" class="form-select">
                    <option value="all">All</option>
                    <option value="FICTION">Fiction</option>
                    <option value="NON_FICTION">Non-Fiction</option>
                    <option value="MYSTERY">Mystery</option>
                    <option value="FANTASY">Fantasy</option>
                    <option value="SCIFI">Sci-Fi</option>
                    <option value="BIOGRAPHY">Biography</option>
                    <option value="HISTORY">History</option>
                    <option value="SELF_HELP">Self-Help</option>
                    <option value="POETRY">Poetry</option>
                    <option value="OTHER">Other</option>
                </select> -->

                <div class="form-label">Minimum Price:</div>
                <input type="number" name="minPrice" class="form-input" value="${param.minPrice}">

                <div class="form-label">Maximum Price:</div>
                <input type="number" name="maxPrice" class="form-input" value="${param.maxPrice}">

                <button type="submit" class="btn btn-primary me-2">Search</button>
            </form>


            <h2>Doctor List</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Firstname</th>
                    <th>Lastname</th>
                    <th>Salary</th>
                    <th>Hire Date</th>
                    <!-- <th>Genre</th> -->
                    <th>Actions</th>
                </tr>
                <c:forEach items="${doctorList}" var="doctor">
                    <tr>
                        <td>${doctor.id}</td>
                        <td>${doctor.firstName}</td>
                        <td>${doctor.lastName}</td>
                        <td>${doctor.salary}</td>
                        <td>${doctor.hireDate}</td>
                        <%-- <td>${book.genre}</td> --%>
                        <td>
                            <a href="${pageContext.request.contextPath}/doctors/edit?id=${doctor.id}"
                                class="btn btn-warning">Edit</a>
                            <a href="${pageContext.request.contextPath}/doctors/delete?id=${doctor.id}"
                                class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </body>

        </html>