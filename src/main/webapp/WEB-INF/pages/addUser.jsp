<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add User</title>
</head>
<body>
<h1>Add a new User</h1>

<form action="/stocker/addUser" method="post" modelAttribute="user">
    <table>
        <tr>
            <td><label for="username">Username: </label></td>
            <td><input id="username" name="username" type="text" value="${user.username}"/></td>
        </tr>
        <tr>
            <td><label for="password">Password: </label></td>
            <td><input id="password" name="password" type="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td><label for="access">Access: </label></td>
            <td><input id="access" name="access" value="${user.access}"/></td>
        </tr>
    </table>
    <input type="submit" value="Create"/>
</form>
</body>
</html>