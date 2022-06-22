<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <a href="ShoppingList?action=logout">Logout</a>
        <h3>List</h3>
        <form method="post" action=""> 
            <label>Add item:</label>
            <input type="hidden" name="action" value="add">
            <input type="text" name="listInput" value="">
            <input type="submit" value="Add">
        </form>
        
        <form method="post" action="">
            <input type="hidden" name="action" value="delete">
            <c:if test="${list != null && list.size() > 0}">
                <c:forEach var="item" items="${list}">
                    <input type="radio" name="shoplist" value="${item}">
                    <label>${item}</label>
                    <br>
                </c:forEach>
                    <input type="submit" value="Delete">
            </c:if>
        </form>
    </body>
</html>
