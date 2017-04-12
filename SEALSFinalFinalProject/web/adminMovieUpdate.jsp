<%-- 
    Document   : adminMovieUpdate
    Created on : Apr 11, 2017, 4:14:28 PM
    Author     : Austin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Movie Edit</h1>
        <div>
            <form method="POST" action='ProductController' name="frmAddProduct">
                <!--Order Number-->
                Order Number: 
                <br>
                <input type="number"  name="orderNumber"
                       value="<c:out value="${product.orderNumber}" />" autofocus required min="1"/> 
                <br> 

                <!--Customer Id-->
                Customer Id: 
                <br>
                <input type="number"  name="customerId"
                       value="<c:out value="${product.customerId}" />" required min="1"/> 
                <br> 

                <!--Product Id-->
                Product Id: 
                <br>
                <input type="number" readonly="readonly" name="productId"
                       value="<c:out value="${product.productId}" />" /> 
                <br> 

                <!--Quantity-->
                Quantity: 
                <br>
                <input type="number"  name="quantity"
                       value="<c:out value="${product.quantity}" />" required min="1"/> 
                <br> 

                <!--Shipping Cost-->
                Shipping cost: <br>
                <input type="number"  name="shippingCost"
                       value="<c:out value="${product.shippingCost}" />" required min="1"/> <br> 
               
                <input type="submit" value="Submit" />
            </form>
        </div>
    </body>
</html>
