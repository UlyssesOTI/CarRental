<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href=<c:url value="/resources/css/style.css"></c:url>>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<body class="bodyMain">
	
	<div class="MainDiv">
		<div class="header">
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
		<div class="MainMenu">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
		</div>
		<div class="body">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
</body>
</html>