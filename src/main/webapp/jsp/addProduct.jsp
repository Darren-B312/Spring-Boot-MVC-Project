<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="product">
		<h1>Add New Product</h1>
		Product Description: <form:input path="pDesc"></form:input> <form:errors path = "pDesc"/><br>
		Quantity in Stock: <form:input path="qtyInStock"></form:input> <form:errors path = "qtyInStock"/><br>
		<input type="submit" value="Add" />	
	</form:form>
	<a href="/index.html">Home</a>
	<a href="/showOrders.html">List Orders</a>
	<a href="/showProducts.html">List Products</a>
</body>
</html>