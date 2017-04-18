<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<center><h1>Shopping Cart</h1></center>
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner" role="listbox">
    <div class="carousel-item active">
      <a href="clickHome"><img align="left" "d-block img-fluid" src="http://www.freeiconspng.com/uploads/home-icon-png-home-icon-31.png" alt="First slide" height="30px"></a>
    </div>
    <div class="carousel-item">
      <a href="clickLogin"><img class="d-block img-fluid" src="http://supermoney.in/themes/custom/images/LOGIN.jpg" alt="Second slide" height="30px"></a>
    </div>
    <div class="carousel-item">
      <center><a href="clickRegister"><img align="right" class="d-block img-fluid" src="http://s3.amazonaws.com/rdcms-hsmai/files/production/public/images/regnowbutton.jpg" alt="Third slide" height="30px"></a></center>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
     <center><a href="clickAbout">About Us</a></center> 
     <center><a href="header">Header</a></center>
</body>
</html>