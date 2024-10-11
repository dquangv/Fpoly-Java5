<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Management</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">Product Management</h1>

    <form:form modelAttribute="product" method="POST" action="${pageContext.request.contextPath}/product/create" class="form-horizontal">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name:</label>
            <div class="col-sm-10">
                <form:input path="name" placeholder="Product Name" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">Price:</label>
            <div class="col-sm-10">
                <form:input path="price" placeholder="Product Price" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="createDate" class="col-sm-2 control-label">Creation Date:</label>
            <div class="col-sm-10">
                <form:input path="createDate" placeholder="Product Creation Date" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="available" class="col-sm-2 control-label">Available:</label>
            <div class="col-sm-10">
                <form:checkbox path="available" class="form-control" style="display: inline;"/>
            </div>
        </div>
        <div class="form-group">
            <label for="category.id" class="col-sm-2 control-label">Category:</label>
            <div class="col-sm-10">
                <form:select path="category.id" class="form-control">
                    <form:options items="${cateList}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button formaction="/product/create" class="btn btn-primary">Create</button>
                <button formaction="/product/update" class="btn btn-success">Update</button>
                <a href="/product/delete/${product.id}" class="btn btn-danger">Delete</a>
                <a href="/product/index" class="btn btn-info">Reset</a>
                <a href="/category/index" class="btn btn-warning">Manage Categories</a>
            </div>
        </div>
    </form:form>

    <!-- Search bar -->
    <!-- Search bar -->
    <form action="${pageContext.request.contextPath}/product/index" method="GET" class="form-horizontal">
        <div class="form-group">
            <label for="keyword" class="col-sm-2 control-label">Search:</label>
            <div class="col-sm-10">
                <input type="text" id="searchKeyword" name="keyword" placeholder="Search by name, price, creation date, or category" class="form-control"/>
                <!-- Preserve sorting and pagination when searching -->
                <input type="hidden" name="field" value="${currentSortField}"/>
                <input type="hidden" name="sortDir" value="${currentSortDir}"/>
            </div>
        </div>
    </form>


    <!-- Display product list -->
    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th><a href="/product/index?page=0&field=id&sortDir=${currentSortDir == 'asc' ? 'desc' : 'asc'}">ID</a></th>
                    <th><a href="/product/index?page=0&field=name&sortDir=${currentSortDir == 'asc' ? 'desc' : 'asc'}">Name</a></th>
                    <th><a href="/product/index?page=0&field=price&sortDir=${currentSortDir == 'asc' ? 'desc' : 'asc'}">Price</a></th>
                    <th><a href="/product/index?page=0&field=createDate&sortDir=${currentSortDir == 'asc' ? 'desc' : 'asc'}">Creation Date</a></th>
                    <th><a href="/product/index?page=0&field=available&sortDir=${currentSortDir == 'asc' ? 'desc' : 'asc'}">Available</a></th>
                    <th><a href="/product/index?page=0&field=category.id&sortDir=${currentSortDir == 'asc' ? 'desc' : 'asc'}">Category</a></th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${page.content}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.createDate}</td>
                        <td>${product.available}</td>
                        <td>${product.category.name}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/product/edit/${product.id}" class="btn btn-primary">Edit</a>
                            <a href="${pageContext.request.contextPath}/product/delete/${product.id}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="/product/index?page=0&field=${currentSortField}&sortDir=${currentSortDir}">|&lt;First</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="/product/index?page=${page.number==0?0:page.number-1}&field=${currentSortField}&sortDir=${currentSortDir}">&lt;&lt;Previous</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="/product/index?page=${page.number==page.totalPages-1?page.totalPages-1:page.number+1}&field=${currentSortField}&sortDir=${currentSortDir}">Next&gt;&gt;</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="/product/index?page=${page.totalPages-1}&field=${currentSortField}&sortDir=${currentSortDir}">Last&gt;|</a>
            </li>
        </ul>
    </nav>

    <div class="row">
        <div class="col-md-12">
            <ul class="list-group">
                <li class="list-group-item">Current Entities: ${page.numberOfElements}</li>
                <li class="list-group-item">Page Number: ${page.number+1}</li>
                <li class="list-group-item">Page Size: ${page.size}</li>
                <li class="list-group-item">Total Entities: ${page.totalElements}</li>
                <li class="list-group-item">Total Pages: ${page.totalPages}</li>
            </ul>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        // Bắt sự kiện khi người dùng gõ ký tự trong ô tìm kiếm
        $('#searchKeyword').on('keyup', function() {
            var keyword = $(this).val();
            var field = $("input[name='field']").val();
            var sortDir = $("input[name='sortDir']").val();

            // Gửi AJAX request
            $.ajax({
                url: '${pageContext.request.contextPath}/product/index',
                method: 'GET',
                data: {
                    keyword: keyword,
                    field: field,
                    sortDir: sortDir
                },
                success: function(response) {
                    // Cập nhật lại nội dung bảng với dữ liệu mới
                    var tableBody = $(response).find('tbody').html();
                    $('tbody').html(tableBody);

                    // Cập nhật lại pagination (nếu cần)
                    var pagination = $(response).find('.pagination').html();
                    $('.pagination').html(pagination);

                    // Cập nhật thông tin về số lượng kết quả
                    var infoList = $(response).find('.list-group').html();
                    $('.list-group').html(infoList);
                }
            });
        });
    });
</script>
</body>
</html>