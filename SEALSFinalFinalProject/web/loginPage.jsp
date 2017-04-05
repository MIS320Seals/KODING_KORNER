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
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <h1>Welcome to the Crimson Video Store website!</h1>
        <h2>We are currently working on getting our memberless viewing up and running.</h2>
        <h3>But until then,</h3>
        <h2>Please log in below to get started</h2>
        <form action="login">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Enter your username:</td>
                        <td><input type="text" name="cust_username" value="" /></td>
                    </tr>
                    <tr>
                        <td>Enter your password:</td>
                        <td><input type="password" name="cust_password" value="" /></td>
                    </tr>
                    <tr>
                        <td><a href="custActionPage.jsp">Break shit</a></td>
                        <td><input type="submit" value="Enter" name="login" /></td>
                    </tr>
                    <tr>
                        <td><a href="adminValidationPage.jsp">New Admin </a></td>
                        <td><a href="custRegisterPage.jsp">New User</a></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
