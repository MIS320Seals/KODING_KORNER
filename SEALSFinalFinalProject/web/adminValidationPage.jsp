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
        <link rel="stylesheet" type="text/css" href="CSS/loginCSS.css">
    </head>
    <body>
        <div>
            <h1 style = "margin-bottom: 0;">Employee Login</h1>
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
                            <td>
                                <form action="loginReturn">
                                    <input type="submit" value="Back" name="returnToLogin" />
                                </form> 
                            </td>
                            <td>
                                <input type="submit" value="Validate" name="checkPassKey" />
                            </td>
                            <input type="hidden" name="action" value="adminLogin"/>
                    
                    </tr>
                    </tbody>
                </table>
            </form>
                        <form action="AdminController" method="GET">
                            <input type="submit" value="Add New Staff Member" name="action" /> 
                        </form>
        </div>
    </body>
</html>
