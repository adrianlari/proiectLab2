<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add product</title>
    </head>
    <body>
        <form method="post" action="/proiectLab/AddProduct">
            <label>Product name</label>
            <input type="text" name="productName" />
            <label>Price</label>
            <input type="number" name="price" step="0.01" min="0" />
            <label>Unit</label>
            <input type="text" name="unit" />
            <label>Quantity</label>
            <input type="number" name="quantity" step="0.01" min="0" />
            
            <input type="submit" value="Adauga!" />
        </form>
    </body>
</html>
