<%-- 
    Document   : users
    Created on : 25-Oct-2022, 12:17:17 PM
    Author     : Aster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        <table>
            <tr>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Role</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr><a href="users?action=view&amp;userId=${user.email}">${note.title}</a><br></tr>
            </c:forEach>
        </table><br>
        <h2>Add User</h2>
        <form>
            Email: <input type="email"><br>
            First name: <input type="text"><br>
            Last name: <input type="text"><br>
            Password: <input type="text"><br>
            Role: <input list="roles">
            <datalist id="roles">
                <option value="system admin">
                <option value="regular user">
            </datalist>
            <input type="submit" value="Add user">
        </form>
    </body>
</html>
