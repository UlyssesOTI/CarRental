<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="managerSaveContract" method="post" modelAttribute="contract">
		<ul>
			
			<li>Name: <form:input path="beginDate" /></li>
			<li>Name: <form:input path="endDate" /></li>
			<li>Name: <form:input path="price" /></li>
			<li>Name: <form:input path="client" /></li>
			<li>Name: <form:input path="date" /></li>

		</ul>
		<button type="submit" name="operation" value="add">Save</button>
	</form:form>
</body>
</html>