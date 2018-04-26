<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/css/style.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="ship">
		<table>
			<tr>
				<td>Ship name:</td>
				<td><form:input path="name"></form:input></td>
				<td><form:errors path="name"></form:errors></td>
			</tr>
			<tr>
				<td>Passengers:</td>
				<td><form:input path="passengers"></form:input></td>
				<td><form:errors path="passengers"></form:errors></td>
			</tr>
			<tr>
				<td>Cost:</td>
				<td><form:input path="cost"></form:input></td>
				<td><form:errors path="cost"></form:errors></td>
			</tr>
			<tr>
				<td>Metres:</td>
				<td><form:input path="metres"></form:input></td>
				<td><form:errors path="metres"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add"/></td>
			</tr>
			
		</table>
	</form:form>
	<br>
	<a href="/index.html">Home</a>
</body>
</html>