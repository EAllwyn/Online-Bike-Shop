<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="Bootstrap/css/bootstrap.css"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Welcome to Shop</title>
<style>
.carousel{
width: 100%;
}
.carousel-inner > .item > img, 
.carousel-inner > .item > a > img{
width: 100%;
min-height: 500px;
max-height: 500px;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<center>
<h2>Welcome to Shop</h2>
<p>${msg}</p>
</center>
<div class="container">
 <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="Resources/images/img1.png" alt="Kawasaki Ninja" width="460" height="345">
        <div class="carousel-caption">
          <h3>Super Bike</h3>
          <p>Exciting Offers visit Store</p>
        </div>
      </div>

      <div class="item">
        <img src="Resources/images/img2.jpg" alt="Yamaha" width="550" height="345">
        <div class="carousel-caption">
          <h3>Sport Bike</h3>
          <p>Great Sale Start on April</p>
        </div>
      </div>
    
      <div class="item">
        <img src="Resources/images/img3.jpg" alt="Suzuki" width="550" height="345">
        <div class="carousel-caption">
          <h3>Super Bike</h3>
          <p>Two Wheels Moves the Soul</p>
        </div>
      </div>

      <div class="item">
        <img src="Resources/images/img4.jpg" alt="Continental GT" width="550" height="345">
        <div class="carousel-caption">
          <h3>Cafe Racer</h3>
          <p>Visit Near Store</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<center><h3>This is Shopping cart Website </h3></center>
<jsp:include page="WebFooter.jsp"></jsp:include>
</body>
</html>
.5