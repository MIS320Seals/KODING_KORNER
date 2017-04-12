<%-- 
    Document   : adminValidationPage
    Created on : Apr 2, 2017, 9:25:40 PM
    Author     : ering
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validation Page</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <h1>Admin Login</h1>
        <h3>Incorrect username or password, please try again</h3>
        <form method="POST" action='LoginController' name="frmValidateKey">
            <table border="0">
                <tbody>
                    <tr>
                            <td>Username:</td>
                            <td><input type="text" name="username" value="${adminBean.username}" required /></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password" value="${adminBean.password}" /></td>
                        </tr>
                    <tr> 
                       <input type="hidden" name="action" value="adminLogin"/></td>
                        <td><input type="submit" value="Validate" name="checkPassKey" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <p></p>
        <p></p>
        <form action="loginReturn">
            <input type="submit" value="Back" name="returnToLogin" />
        </form>
    </body>
</html>
