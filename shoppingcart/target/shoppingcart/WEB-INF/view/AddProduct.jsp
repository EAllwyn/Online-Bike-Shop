<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Resources/Bootstrap/css/bootstrap.min.css">
<script src="Resources/Bootstrap/js/bootstrap.min.js"></script>
<script src="Resources/JQuery/jquery-3.1.1.min.js"></script>
<title>Product Addition</title>
</head>
<body>
<center>
<form class="form-horizontal" method="post" action="addProduct" modelattribute="Product">
<div class="col-xs-6">
    <div class="input-group">
   
	<span class="input-group-addon"> <!--  -->Product Id </span>
      <input type="text" class="form-control" placeholder="Enter Product ID" path="productID">
    </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon"> Product Name </span>
      <input type="text" class="form-control" id="prodName" placeholder="Enter Product Name" path="productName">
    </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon"> Product Desc </span>
      <input type="text" class="form-control" id="prodDesc" placeholder="Enter Product Desc" path="productDesc">
    </div>
    <br>
    <div class="input-group">
     <span class="input-group-addon"> Supplier ID </span>
      <input type="text" class="form-control" id="suppID" placeholder="Enter Supplier ID" path="supplierID">
    </div>
    <br>
        <div class="input-group">
     <span class="input-group-addon"> Category ID </span>
      <input type="text" class="form-control" id="categID" placeholder="Enter Category ID" path="categoryID">
    </div>
    <br>
    <div class="input-group">
	<span class="input-group-addon"> Product Quantity </span>
      <input type="text" class="form-control" id="prodQty" placeholder="Enter Product Quantity" path="productQty">
    </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon"> Product Cost </span>
      <input type="text" class="form-control" id="prodCost" placeholder="Enter Product cost" path="productCost">
    </div>
    
    <br>
    
    <button type="submit" class="btn btn-default"> Add Product </button>
    
    </div>
  </form>
  </center>
</body>
</html>