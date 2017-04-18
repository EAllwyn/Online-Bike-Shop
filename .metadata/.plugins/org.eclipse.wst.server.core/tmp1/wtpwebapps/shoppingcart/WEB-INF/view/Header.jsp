<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="clickHome">BIKECART</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="clickHome">Home</a></li>
      <li><a href="clickAbout">About Us</a></li>
       <c:if test="${not empty AdminMsg }">
      <li><a href="clickAdmin">Admin</a></li>
      </c:if> 
      </ul>
      <ul class="nav navbar-nav">
      <li><a href="clickProducts">Products</a></li>
      <c:if test="${not empty UserMsg }">
      <li><a href="clickMyCart">MyCart</a></li>
      </c:if>
      <c:if test="${not empty AdminMsg }">
      <li><a href="clickAdmin">Overall Management</a></li>
      </c:if>
    </ul>
      <c:if test="${ not empty loginMsg }">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="clickRegister"><span class="glyphicon glyphicon-user"></span>Register</a></li>
      <li><a href="clickLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
    </c:if>
    <c:if test="${not empty UserMsg }">
      <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <span class="glyphicon glyphicon-user"></span>${ UserName }
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Modify Account</a></li>
          <li><a href="clickLogout">Logout</a></li>
        </ul>
      </li>
      </ul>
      </c:if>
      <c:if test="${not empty AdminMsg }">
      <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <span class="glyphicon glyphicon-user"></span>${ UserName }
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Modify Account</a></li>
          <li><a href="clickLogout">Logout</a></li>
        </ul>
      </li>
      </ul>
      </c:if>
 </nav>