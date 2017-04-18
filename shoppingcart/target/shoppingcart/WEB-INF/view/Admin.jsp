<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale00000000000000000=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Admin</title>
<script type="text/javascript">
function cFunc()
{
	var form_value=document.getElementById('sel1').value;
	if(form_value=="AddProduct")
	{
	window.location="selAddProduct";
	}
	if(form_value=="EditProduct")
	{
	window.location="selAddProduct";
	}
}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container">        
  <table class="table">
    <thead>
      <tr>
        <th>Product</th>
        <th>Category</th>
        <th>User Details</th>
      </tr>
    </thead>
    <div class="form-group">
    <tbody>
      <tr>
        <td>
      <select class="form-control" id="sel1" onchange="cFunc()">
      	<option>--Select--</option>
        <option value="AddProduct">Add</option>
        <option value="EditProduct">Edit</option>
        <option onselect="delete_product" value="">DeleteProduct</option>
      </select>
        </td>
        <td>
      <select class="form-control" id="sel2">
      <option>--Select--</option>
        <option>Add</option>
        <option>Edit</option>
        <option>Delete</option>
      </select>
        </td>
        <td>
        <select class="form-control" id="sel3">
        <option>--Select--</option>
        <option>Add</option>
        <option>Edit</option>
        <option>Delete</option>
      </select>
        </td>
      </tr>
      
    </tbody>
    </div>
  </table>
</div>
<jsp:include page="WebFooter.jsp"></jsp:include>
</body>
</html>