<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<form:form action="allClientsNewClient" method="post" modelAttribute="client" enctype="multipart/form-data" >
		<ul>
			
			<li>lastName: <form:input path="lastName" /></li>
			<li>Name: <form:input path="firstName" /></li>
			<li>email: <form:input path="email" /></li>
			<li>password: <form:input path="password" /></li>
			
		</ul>
		<button type="submit" name="operation" value="add">Save</button>
	</form:form>
</body>