<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<form:form action="cEditClient" method="post" modelAttribute="client">
		<ul>
			<li><form:input path="id" type="hidden"/></li>
			<li>Last name: <form:input path="lastName"/></li>		
			<li>First name: <form:input path="firstName"/></li>
			<li>email: <form:input path="email"/></li>
			<li>password: <form:input path="password"/></li>
		</ul>
		<button type="submit" name="operation" value="update">Save</button>
	</form:form>
</body>