<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style>
@font-face {
  font-family: 'Glyphicons Halflings';
  src: url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.eot');
  src: url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.woff') format('woff'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.ttf') format('truetype'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.svg#glyphicons-halflingsregular') format('svg');
}
.navbar-custom
{
color: #FFFFFF;
background-color: #18767a;
}
.navbar-custom .navbar-nav > li > a:hover, .navbar-custom .navbar-nav > li > a:focus {
color: #18767a;  /*Sets the text hover color on navbar*/
}


  .dropdown-menu > li > a:hover,
   .dropdown-menu > li > a:focus {
    color: #262626;
   text-decoration: none;
  background-color: #66CCFF;  /*change color of links in drop down here*/
   }

 .nav > li > a:hover,
 .nav > li > a:focus {
    text-decoration: none;
    background-color: silver; /*Change rollover cell color here*/
  }

    .navbar a {
    color: white;
}
</style>
</head>
<body>
<nav class="navbar navbar-custom">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="clickHome">shoppingcart</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="clickAdmin">Cart</a></li>
    </ul>
        <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <span class="glyphicon glyphicon-user"></span>
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Logout</a></li>
          <li><a href="#">History</a></li>
          <li><a href="#">Info</a></li>         
        </ul>
      </li>
        </ul>
  </div>
</nav>
</body>
</html>