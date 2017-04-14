<%-- 
    Document   : adminEmpView
    Created on : Apr 13, 2017, 8:44:40 PM
    Author     : Austin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class = "hdr">
            <h1>Customer Details</h1>
        </div
        <div class = "frmRegDiv">
        <form class = "frmReg" action="custRegister">
            <table border="0">
                <tbody>
                   
                    <tr>
                        <td>Customer ID:</td>
                        <td><input type="text" name="customerId" value="${cust.id}" readonly /></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" value="${cust.name}" /></td>
                    </tr>
                    <tr>
                        <td>Street Address:</td>
                        <td><input type="text" name="address" value="${cust.address}" /></td>
                    </tr>
                    <tr>
                        <td>Zip Code:</td>
                        <td><input type="text" name="zip" value="${cust.zip}" /></td>
                    </tr>
                    <tr>
                        <td>Phone:</td>
                        <td><input type="text" name="phone" value="${cust.phoneNumber}" /></td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td><input type="text" name="city" value="${cust.city}" /></td>
                    </tr>
                    <tr>
                        <td>Country:</td>
                        <td><input type="text" name="country" value="${cust.country}" /></td>
                    </tr>
                    <tr>
                        <td>Notes:</td>
                        <td><input type="text" name="notes" value="${cust.notes}" /></td>
                    </tr>
                    <tr>
                        <td>Store:</td>
                        <td><input type="text" name="storeId" value="${cust.storeId}" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Enter" name="custRegister" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
