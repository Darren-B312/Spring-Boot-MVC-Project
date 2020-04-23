<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of Customers</h1>
	<ul>
		<c:forEach items="${customers}" var="customer">
			<h2>${customer.cId} ${customer.cName}</h2>	
		</c:forEach>
	</ul>
</body>
</html>