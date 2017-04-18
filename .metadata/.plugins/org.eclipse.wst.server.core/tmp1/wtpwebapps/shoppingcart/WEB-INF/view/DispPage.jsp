<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<jsp:include page="WebHeader.jsp"></jsp:include>
<c:if test="${ showPage==indexPage }">
<jsp:include page="index.jsp"></jsp:include>
</c:if>
<c:if test="${showPage==loginPage}">
<jsp:include page="Login.jsp"></jsp:include>
</c:if>
<c:if test="${showPage==regPage}">
<jsp:include page="Register.jsp"></jsp:include>
</c:if>
<c:if test="${showPage==aboutPage}">
<jsp:include page="AboutUs.jsp"></jsp:include>
</c:if>
<jsp:include page="WebFooter.jsp"></jsp:include>
</body>
</html>