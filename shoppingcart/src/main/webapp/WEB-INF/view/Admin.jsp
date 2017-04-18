<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Admin</title>
<script type="text/javascript">
function pFunc()
{
	var pform_value=document.getElementById('sel1').value;
	if(pform_value=="AddProduct")
	{
	window.location="selAddProduct";
	}
	if(pform_value=="EditProduct")
	{
	window.location="selEditProduct";
	}
	if(pform_value=="DeleteProduct")
	{
	window.location="selDeleteProduct";
	}
	if(pform_value=="ViewProduct")
	{
	window.location="selViewProduct";
	}	
}
function cFunc()
{
	var cform_value=document.getElementById('sel2').value;
	if(cform_value=="AddCategory")
		{
		window.location="selAddCategory";
		}
	if(cform_value=="EditCategory")
	{
	window.location="selEditCategory";
	}
	if(cform_value=="DeleteCategory")
	{
	window.location="selDeleteCategory";
	}
	if(cform_value=="ViewCategory")
	{
	window.location="selViewCategory";
	}
}
function sFunc()
{
	var sform_value=document.getElementById('sel3').value;
	if(sform_value=="AddSupplier")
	{
	window.location="selAddSupplier";
	}
	if(sform_value=="EditSupplier")
	{
	window.location="selEditSupplier";
	}
	if(sform_value=="DeleteSupplier")
	{
	window.location="selDeleteSupplier";
	}
	if(sform_value=="ViewSupplier")
	{
	window.location="selViewSupplier";
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
        <th>Supplier</th>
      </tr>
    </thead>
    <div class="form-group">
    <tbody>
      <tr>
        <td>
      <select class="form-control" id="sel1" onchange="pFunc()">
      	<option>--Select--</option>
        <option value="AddProduct">Add</option>
        <option value="EditProduct">Edit</option>
        <option value="DeleteProduct">Delete</option>
        <option value="ViewProduct">View</option>
      </select>
        </td>
        <td>
      <select class="form-control" id="sel2" onchange="cFunc()">
      <option>--Select--</option>
        <option value="AddCategory">Add</option>
        <option value="EditCategory">Edit</option>
        <option value="DeleteCategory">Delete</option>
        <option value="ViewCategory">View</option>
      </select>
        </td>
        <td>
        <select class="form-control" id="sel3" onchange="sFunc()">
        <option>--Select--</option>
        <option value="AddSupplier">Add</option>
        <option value="EditSupplier">Edit</option>
        <option value="DeleteSupplier">Delete</option>
        <option value="ViewSupplier">View</option>
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