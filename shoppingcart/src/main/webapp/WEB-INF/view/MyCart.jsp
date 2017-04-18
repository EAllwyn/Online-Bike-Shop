<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Bike</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="row">
 <c:forEach items="${prList}" var="pList">
    <div class="col-xs-6 col-md-3">
      <div class="thumbnail">
        <img src="Resources/images/${pList.proID}.jpg" height="75">
          <div class="caption">
          <p>Cost: ${pList.prodCost}</p>
          <form action="removeProductFromCart">
          <input type="hidden" name="prID" value="${pList.proID}">
          <input type="submit" value="Remove from Cart">
          </form>
          </center>
          </div>
          </div>
    </div>
    </c:forEach>
    </div>
</body>
</html>