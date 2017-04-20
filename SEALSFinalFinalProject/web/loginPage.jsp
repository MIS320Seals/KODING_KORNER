<%-- 
    Document   : loginPage
    Created on : Mar 31, 2017, 3:31:56 PM
    Author     : ering
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <a href="loginPage.jsp"></a>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="CSS/loginCSS.css">
    </head>
    <body>

        <div style="text-height: auto; background-color: #cc0000">
            <img src="rex/Logo.PNG" Style = " height: 100px;width: 100px;padding: 10px; margin: 0; "/>
            <h1 style="float: right; text-align: justify;">Crimson Video Store</h1>
        </div>

        <br>
        <div class="loginTable" >
            <form action="LoginController" method="POST">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Username:</td>
                            <td><input type="text" name="username" value="${custbean.username}"  /></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password" value="${custbean.password}" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Enter" name="custLogin" /></td>
                            <td><a href="custRegisterPage.jsp">New User</a></td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="action" value="custLogin"/></td></td>
                        </tr>
                    </tbody>

                </table>

            </form>
            <td><a href="adminValidationPage.jsp">Admin Portal</a></td>
        </div>
    </body>
</html>
