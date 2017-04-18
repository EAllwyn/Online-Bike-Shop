<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Registration</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<center>
<div class="container">
<form class="form-horizontal" action="regtrtn">
<div class="input-group">
<span class="input-group-addon"> Name </span>
 <input type="text" class="form-control" placeholder="Enter Name" name="uname"><br>
</div>
<br>
<div class="input-group">
<span class="input-group-addon"> Password</span>
<input type="password" class="form-control" placeholder="Enter password" name="uemail"><br>
</div>
<br>
<div class="input-group">
<span class="input-group-addon">Email id </span>
<input type="text" class="form-control" placeholder="Enter Email id" name="upwd"><br>
</div>
<br>
<div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
</form>
</div>
<jsp:include page="WebFooter.jsp"></jsp:include>
</body>
</html>