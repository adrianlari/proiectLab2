<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit product</title>
    </head>
    <body>
        <form method="post" action="/proiectLab/EditProduct?edited=edited">
            <input type="text" name="id" value="${product.id}" style="visibility: collapse;position: absolute" />
            <label>Product name</label>
            <input type="text" value="${product.productName}" name="productName" />
            <label>Price</label>
            <input type="number" value="${product.price}" name="price" step="0.01" min="0" />
            <label>Unit</label>
            <input type="text" value="${product.unit}" name="unit" />
            <label>Quantity</label>
            <input type="number" value="${product.quantity}" name="quantity" />
            
            <input type="submit" value="Editeaza!" />
        </form>
    </body>
</html>
