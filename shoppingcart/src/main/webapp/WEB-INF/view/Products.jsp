<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="Resources/bootstrap/thumbnail-gallery.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>View Bikes</title>
<style>
img {
  display: block;
  max-width: 100%;
  height: auto;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
 <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Bikes</h1>
            </div>
            <c:forEach items="${prList}" var="pList">
            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="Resources/images/${pList.productID}.jpg" alt="${pList.productName}" >
                    <c:if test="${not empty UserMsg }">
                    <center><p>${pList.productName }</p></center>
                    <center>
                    <form action="addProductToCart">
                    <input type="hidden" id="prdAddId" name="prdAddId" value="${pList.productID}">
                    <input type="submit" Value="Buy">
                    </form>
                    </center>
                    </c:if>
                </a>
            </div>
            </c:forEach>
       </div>
  </div>
<jsp:include page="WebFooter.jsp"></jsp:include>
</body>
</html>