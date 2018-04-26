<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/css/style.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>

		<tr>
			<th>Order Number</th>
			<th>Shipping Company Name</th>
			<th>Ship Name</th>
			<th>Order Date</th>
		</tr>
		
		<c:forEach items="${shipO}" var="ship">

			<tr>
				<td>${ship.oid}</td>
				<td>${ship.shippingCompany.name}</td>
				<td>${ship.ship.name}</td>
				<td>${ship.date}</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>