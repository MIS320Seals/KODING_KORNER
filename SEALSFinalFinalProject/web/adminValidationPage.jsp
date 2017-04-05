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
        <h1>Hello potential administrator</h1>
        <h3>Please type in your administration passkey to continue to registration.</h3>
        <form action='AdminController?action=validate&passKey=<c:out value="passKey" />' name="frmValidateKey">
            <table border="0">
                <tbody>
                    <tr>
                        <td><input type="password" name="passKey" value="" /></td>
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
