<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${session.username}</p>
        <a href="">Logout</a>
        <h3>List</h3>
        
        <form> 
            <label>Add item:</label>
            <input type="hidden" name="action" value="add">
            <input type="text" name="listInput" value="">
            <input type="submit" value="Add">
        </form>
    </body>
</html>
