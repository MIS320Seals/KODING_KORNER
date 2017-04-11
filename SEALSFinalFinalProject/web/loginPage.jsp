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
            <form action="LoginController" method="POST" style = "margin: auto; width: 90%;">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Email:</td>
                            <td><input type="email" name="email" value="${custbean.email}"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}"/></td>
                        </tr>
                        <tr>
                            <td>ID:</td>
                            <td><input type="password" name="id" value="${custbean.id}" required min = "1"/></td>
                        </tr>
                        <tr>
                            <td><a href="custActionPage.jsp">cust login break</a></td>
                            <td><a href="adminActionPage.jsp">admin login break</a></td>
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
        <h3>We are currently working on getting our member less viewing up and running.</h2>
        <h3>But until then,</h3>
        <h3>Please log in below to get started</h2>
    </body>
</html>
