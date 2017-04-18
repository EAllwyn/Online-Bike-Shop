<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="Resources/JQuery/jquery-3.1.1.min.js"></script>
<title>Welcome User</title>
<style type="text/css">
.thumbnail{        
    <!-- width : 100%; -->
    overflow: initial;
    height: 400px;
}

.thumbnail img {
    max-height: 100%;
    max-width: 100%;
}
</style>
<script type="text/javascript">
function viewUserCart()
{
	window.location="viewUserCart";
}
function addProdtoCart()
{
	window.location="addProdtoCart"
}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<button type="button" class="btn btn-primary" id="ViewCart" onclick="viewUserCart()">View your Cart</button>
 <div class="container">
  <h2>Bike</h2>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Supplier Id</th>
        <th>Category Id</th>
        <th>Product Quantity</th>
        <th>Product Cost</th>
        <th>Buy</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${prodsInCart}" var="pList">
      <tr>
        <td><c:out value="${pList.productID}" /></td>
        <td><c:out value="${pList.productName}" /></td>
        <td><c:out value="${pList.productDesc}" /></td>
        <td><c:out value="${pList.supplierID}" /></td>
        <td><c:out value="${pList.categoryID}" /></td>
        <td><c:out value="${pList.productQty}" /></td>
        <td><c:out value="${pList.productCost}" /></td>
        <td><button type="button" class="btn btn-primary" id="prodID" onclick="addProdtoCart()" value="${pList.productID}">Add to Cart</button></td>
      </tr><!-- form action addtocart one input for prodQty one input hidden prodId -->
       </c:forEach>
    </tbody>
  </table>
</div>
<jsp:include page="WebFooter.jsp"></jsp:include>
</body>
</html>