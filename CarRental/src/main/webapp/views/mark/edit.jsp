<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<form:form action="saveMark" method="post" modelAttribute="mark">
		<ul>
			<li>Mark name: <form:input path="id" readonly="true"/></li>
			<li>Mark name: <form:input path="markName"/></li>		
		</ul>
		<button type="submit" name="operation" value="update">Save</button>
	</form:form>
</body>