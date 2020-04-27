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
	<h1>New Order</h1>
	<form:form modelAttribute="order">
		Customer: <form:select path="cust" items="${customerMap}"></form:select>
		Product: <form:select path="prod" items="${productMap}"></form:select>
		Quantity: <form:input path="qty"></form:input>
		<input type="submit" value="Order" />
	</form:form>
</body>
</html>