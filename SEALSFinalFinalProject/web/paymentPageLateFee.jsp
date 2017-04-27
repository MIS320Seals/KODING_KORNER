<%-- 
    Document   : paymentPage
    Created on : Apr 18, 2017, 2:20:37 PM
    Author     : Lauren
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Page</title>
    </head>
    <body>
        <jsp:useBean id="rental" scope="session" class="com.SEALS.film.Rental" />

        <jsp:setProperty name="rental" property="lateFee" />
                <jsp:setProperty name="rental" property="rentalID" />


        <h1> You have a late fee of $<jsp:getProperty name="rental" property="lateFee" /> </h1>           


            <form action="RentalController" >
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
                <input type="hidden" name="action" value="paymentLateFeeValidation"/>
                <input type="hidden" name="rentalID" value ="<jsp:getProperty name="rental" property="rentalID" />"/>
            </form>

    </body>
</html>
