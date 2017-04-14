<%-- 
    Document   : loginPage
    Created on : Mar 31, 2017, 3:31:56 PM
    Author     : ering
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="CSS/loginCSS.css">
    </head>
    <body style = "text-align: center;">
        <div class="hdr">
            <h1>Crimson Video Store</h1>
           <h1>Incorrect Login, Please Try Again</h1>
        </div>
        <div>
            <form action="LoginController" method="POST" style = "margin: auto; width: 90%;">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Username: </td>
                            <td><input type="text" name="username" value="${custbean.username}"  required /></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password" value="${custbean.password}" required min = "1"/></td>
                        </tr>
                        <tr>    
                            <input type="hidden" name="action" value="custLogin"/></td>
                            <td><input type="submit" value="Enter" name="custLogin" /></td>
                        </tr>
                        <tr>
                            <td><a href="adminValidationPage.jsp">Admin Portal</a></td>
                            <td><a href="custRegisterPage.jsp">New User</a></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
