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
	<form:form modelAttribute="customer">
		<h1>Add New Customer</h1>
		Cust Name: <form:input path="cName"></form:input><form:errors path = "cName"/></br>
		<input type="submit" value="Add" />
	</form:form>
	<a href="/index.html">Home</a>
	<a href="/showOrders.html">List Orders</a>
	<a href="/showProducts.html">List Products</a>

</body>
</html>