<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="/css/style.css" rel="stylesheet" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Order Error</title>
	</head>
	<body>
		<h1>Error Creating the Order</h1>
		<h2>${errorMessage}</h2>
		<a href="/">Home</a>
	</body>
</html>