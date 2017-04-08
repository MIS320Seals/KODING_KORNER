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
    <body style = "text-align: center;">
        <div class="hdr">
            <h1>Crimson Video Store</h1>
           
        </div>
        <div Style = "background-color: whitesmoke; margin:auto; width:45%; border-radius: 5px; text-align: center;">
            <form action="login" style = "margin: auto; width: 90%;">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Username:</td>
                            <td><input type="text" name="cust_username" value="" /></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="cust_password" value="" /></td>
                        </tr>
                        <tr>
                            <td><a href="custActionPage.jsp">Break shit</a></td>
                            <td><input type="submit" value="Enter" name="login" /></td>
                        </tr>
                        <tr>
                            <td><a href="adminRegisterPage.jsp">Admin</a></td>
                            <td><a href="custRegisterPage.jsp">New User</a></td>
                        </tr>
                    </tbody>
                </table>

            </form>
             
        </div>
        <h3>We are currently working on getting our member less viewing up and running.</h2>
        <h3>But until then,</h3>
        <h3>Please log in below to get started</h2>
    </body>
</html>
