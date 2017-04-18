<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<form:form method="post" action="EditProduct" modelattribute="Product">
Product ID:<form:input path="productID"/><br>
Product Name:<form:input path="productName"/><br>
Product Description:<form:input path="productDesc"/><br>
Supplier ID:<form:input path="supplierID"/><br>
Category ID:<form:input path="categoryID"/><br>
Product Quantity:<form:input path="productQty"/><br>
Product Cost:<form:input path="productCost"/><br>
<input type="submit" value="Add Product">
</form:form>
</body>
</html>