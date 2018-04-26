<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Orders</title>
</head>
<body>
	<h1>New Orders</h1>
	<form:form modelAttribute="orderInfo">
		<table>
			<tr>
				<td>Ship Name</td>
				<td><form:select path="ship.sid" items="${shipList}" /></td>
				<td><form:errors path="ship.sid"></form:errors></td>
			</tr>
			<tr>
				<td>Shipping Company</td>
				<td><form:select path="shippingCompany.scid" items="${companyList}" /></td>
				<td><form:errors path="shippingCompany.scid"></form:errors></td>
			</tr>
		</table>
		<input type="submit" value="Order Ship">
	</form:form>
		<br>
	<a href="/index.html">Home</a>
</body>
</html>