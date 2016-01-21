<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<form:form action="managerNewCar" method="post" modelAttribute="car" enctype="multipart/form-data" >
		<ul>
			<li>Registration Number: <form:input path="regNumber" /></li>
			<form:errors  path="regNumber" cssStyle="color: #ff0000;" />
			<li>Model: <form:select path="model">
					<form:options items="${models}" itemValue="id" itemLabel="modelName" />
				</form:select>
			</li>
			<li>Color: <form:select path="color">
					<c:forEach var="color" items="${colors}">
						<option value="${color}">${color}</option>
					</c:forEach>
				</form:select>
			</li>
		</ul>
		<button type="submit" name="operation" value="update">Save</button>
		
		
	</form:form>
</body>