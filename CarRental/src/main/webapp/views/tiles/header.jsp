<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<sec:authorize access="isAuthenticated()">
			<a class="aHeader" href="/CarRental"></a>
		</sec:authorize>
		<sec:authorize access="hasRole('ADMIN')">
			<a class="aHeader" href="managerMain"></a>
		</sec:authorize>
	
		<div class="log">
			<sec:authorize access="isAuthenticated()">
				Hello, 
				<a href="logout">Logout</a>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<a href="loginpage">Login</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ADMIN')">
				<a href="managerMain">Manager main page</a>
			</sec:authorize>
		</div>
	</body>
</html>