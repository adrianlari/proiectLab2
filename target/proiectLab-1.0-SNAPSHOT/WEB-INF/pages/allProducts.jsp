<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Products</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Unit</th>
                <th>Quantity</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${allProducts}" var="product">
                <tr>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.unit}</td>
                    <td>${product.quantity}</td>
                    <td><input type="button" class="btn" onclick="location.href = '/proiectLab/EditProduct?productId=${product.id}'" value="🖍Edit"/></td>
                    <td><input type="button" class="btn" onclick="location.href = '/proiectLab/DeleteProduct?productId=${product.id}'" value="❌Delete"/></td>
                </tr>
            </c:forEach>
        </table>


        <input type="button" onclick="location.href = '/proiectLab'" value="⬅️"/>
        <form action="/proiectLab/AllProducts" method="get" >
            <label for="unit">Filter by:</label>
            <select id="unit" name="unit">
                <option value="none">None</option>
                <option value="kg">Kilogram</option>
                <option value="litru">Litru</option>
                <option value="bucata">Bucata</option>
            </select>
            <input type="submit" value="Filtreaza!" />
        </form>
        
        <button onclick="location.href = '/proiectLab/AllProducts?sort=true'"">Sorteaza dupa nume si UM</button>
    </body>
</html>
