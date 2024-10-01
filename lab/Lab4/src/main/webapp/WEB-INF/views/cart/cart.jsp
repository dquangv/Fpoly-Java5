<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Lab 4 bài 5 - Shopping Cart</title>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    margin: 0;
                    padding: 20px;
                    background-color: #f0f0f0;
                }

                table {
                    width: 100%;
                    border-collapse: collapse;
                    background-color: #ffffff;
                    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                }

                th,
                td {
                    padding: 15px;
                    text-align: left;
                    border-bottom: 1px solid #ddd;
                }

                th {
                    background-color: #f2f2f2;
                    font-weight: bold;
                }

                input[type="text"] {
                    width: 50px;
                    padding: 5px;
                }

                a {
                    text-decoration: none;
                    color: #007bff;
                    font-weight: bold;
                    margin-right: 10px;
                }

                a:hover {
                    text-decoration: underline;
                }

                .summary {
                    margin-top: 20px;
                    float: right;
                    text-align: right;
                }

                .actions {
                    margin-top: 20px;
                    float: right;
                    clear: both;
                    display: flex;
                    justify-content: space-between;
                }

                .actions form {
                    margin: 0 10px;
                }

                .actions button {
                    padding: 10px 20px;
                    background-color: #007bff;
                    color: white;
                    border: none;
                    border-radius: 20px;
                    cursor: pointer;
                    transition: background-color 0.3s ease;
                }

                .actions button:hover {
                    background-color: #0056b3;
                }

                .remove-btn {
                    padding: 10px 20px;
                    background-color: #e74c3c;
                    /* Changed to a more prominent color for visibility */
                    color: white;
                    border: none;
                    border-radius: 20px;
                    cursor: pointer;
                    transition: background-color 0.3s ease;
                }

                .remove-btn:hover {
                    background-color: #c0392b;
                    /* Changed to a darker shade on hover for visual feedback */
                }

                .clearfix::after {
                    content: "";
                    display: table;
                    clear: both;
                }
            </style>
        </head>

        <body>
            <h1>Your Shopping Cart</h1>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Amount</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- <c:forEach var="item" items="${cart.value}"> --%>
                        <c:forEach var="entry" items="${cart}">
                            <c:set var="item" value="${entry.value}" />
                            <tr>
                                <%-- <form action="/cart/update/${item.id}" method="post"> --%>
                                    <input type="hidden" name="id" value="${item.id}">
                                    <td>${item.id}</td>
                                    <td>${item.name}</td>
                                    <td>$${item.price}</td>
                                    <td>
                                        <input type="number" name="qty" value="${item.qty}" min="1"
                                            onchange="updateQuantity(${item.id})">
                                    </td>
                                    <td>$${item.amount}</td>
                                    <td>
                                        <form action="/cart/remove/${item.id}" method="post">
                                            <input type="hidden" name="id" value="${item.id}">
                                            <button type="submit" class="remove-btn">Remove</button>
                                        </form>
                                    </td>
                                    <!--  </form> -->
                            </tr>
                        </c:forEach>
                </tbody>
            </table>
            <div class="clearfix">
                <div class="summary">
                    <h3>Order Summary</h3>
                    <p>Total Items: ${quality}</p>
                    <p>Total Amount: $${sum}</p>
                </div>
                <div class="actions">

                    <form action="/item/index" method="get">
                        <%-- <button type="submit">Continue Shopping</button> --%>
                            <button type="submit">Continue Shopping</button>
                    </form>
                    <form action="/cart/clear" method="post">
                        <%-- <button type="submit">Clear Cart</button> --%>
                            <button type="submit" onclick="clearCart()">Pay Bill</button>
                    </form>
                </div>
            </div>
            <script>
                function clearCart() {
                    $.ajax({
                        url: '${pageContext.request.contextPath}/cart/clear',
                        type: 'POST',
                        success: function (response) {
                            loadContent('cart/view');
                        },
                        error: function (xhr, status, error) {
                            console.error('Error clearing cart:', error);
                        }
                    });
                }

                function continueShopping() {
                    loadContent('item/index');
                }
                function removeItem(itemId) {
                    $.ajax({
                        url: '${pageContext.request.contextPath}/cart/remove/' + itemId,
                        type: 'GET',
                        success: function (response) {
                            loadContent('cart/view');
                        },
                        error: function (xhr, status, error) {
                            console.error('Error removing item:', error);
                        }
                    });
                }
                function loadContent(page) {
                    $.ajax({
                        url: '${pageContext.request.contextPath}/' + page,
                        type: 'GET',
                        success: function (response) {
                            $('#content').html(response);
                        },
                        error: function (xhr, status, error) {
                            console.error('Error loading content:', error);
                        }
                    });
                }
                function updateQuantity(itemId) {
                    var qty = document.querySelector('input[name="qty"][value="' + itemId + '"]').value;

                    $.ajax({
                        url: '${pageContext.request.contextPath}/cart/update/' + itemId,
                        type: 'POST',
                        data: { id: itemId, qty: qty },
                        success: function (response) {
                            // Reload cart content after updating quantity
                            loadContent('cart/view');
                        },
                        error: function (xhr, status, error) {
                            console.error('Error updating quantity:', error);
                        }
                    });
                }

            </script>
        </body>

        </html>