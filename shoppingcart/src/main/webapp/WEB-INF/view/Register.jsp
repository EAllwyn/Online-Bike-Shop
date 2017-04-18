<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="Resources/JQuery/jquery-3.1.1.min.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<center><p>Enter User Details</p>
<form:form method="post" action="addUser" modelattribute="User">
<div class="form-group">
<label for="title">Enter your ID:</label>
<form:input path="userID"/>
</div><br>
<div class="form-group">
<label for="title">Enter your First Name:</label>
<form:input path="userFirstName"/>
</div><br>
<div class="form-group">
<label for="title">Enter your Last Name:</label>
<form:input path="userLastName"/>
</div><br>
<div class="form-group">
<label for="title">Enter your Email:</label>
<form:input path="userEmail"/>
</div><br>
<div class="form-group">
<label for="title">Enter your Password:</label>
<form:input type="password" path="userPassword"/>
</div><br>
<div class="form-group">
<label for="title">Enter your Address:</label>
<form:input path="userAddress"/>
</div><br>
<input type="submit" value="Register">
</form:form>
</center>
<br>
<br>
<br>
<jsp:include page="WebFooter.jsp"></jsp:include>
</body>
</html>