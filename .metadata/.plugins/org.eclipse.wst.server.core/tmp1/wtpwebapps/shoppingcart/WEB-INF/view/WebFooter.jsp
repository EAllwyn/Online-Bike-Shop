<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="FontAwesome/css/font-awesome.min.css">
<link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function cprdisplay()
{
	document.getElementById('mytext').innerHTML = 'Coryrights owned by Allwyn';
}
function cntdisplay()
{
	document.getElementById('mytext').innerHTML = 'Contact @ Allwyn';
}
function spnrdisplay()
{
	document.getElementById('mytext').innerHTML = 'Sponsored by Allwyn';
}
</script>
</head>
<body>
<center>
<button title="Copyright" onclick="cprdisplay()"><i class="fa fa-copyright"></i></button><!-- Copyright -->
<button title="Contact" onclick="cntdisplay()"><i class="fa fa-phone"></i></button><!-- Contact -->
<button title="Our Sponsors" onclick="spnrdisplay()"><i class="fa fa-inr"></i></button><!-- Our Sponsors -->
</center>
<center><p id="mytext"></p></center>
<!-- to adjust size and color i class="fa fa-car" style="font-size:60px;color:red;"></i> -->
<!--  to use circle in icon <span class="fa-stack">
    <i class="fa fa-circle-thin fa-stack-2x"></i>
    <i class="fa fa-twitter fa-stack-1x"></i>
  </span> -->
  <br>
  
</body>
</html>