<%-- 
    Document   : paymentPage
    Created on : Apr 18, 2017, 2:20:37 PM
    Author     : Lauren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Page</title>
    </head>
    <body>
        <h2> Error - Invalid Card Information</h2>
        
        <h4> Please enter valid card information </h4>
        <form action="cartController" >
            <table border="0">
                <tbody>
                    <tr>
                        <td>Input Card Number</td>
                        <td><input type="text" name="username" value="${custbean.username}" required min="13" max="16"  /></td>
                    </tr>
                    <tr>
                        <td>Expiration date:</td>
                        <td><input type="text" name="exp_date" value="" /></td>
                    </tr>
                    <tr>
                        <td>Pin:</td>
                        <td><input type="text" name="pin" value="" /></td>
                    </tr>

                </tbody>
            </table>

            <input type="submit" value="Finish and Pay" name="Finish and Pay" />
            <input type="hidden" name="action" value="paymentValidation"/>
        </form>

    </body>
</html>
