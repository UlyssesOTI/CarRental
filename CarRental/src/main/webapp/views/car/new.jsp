<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<form:form action="newCar" method="post" modelAttribute="car" enctype="multipart/form-data" >
		<ul>
			<li>Registration Number: <form:input path="regNumber" /></li>
			<form:errors  path="regNumber" cssStyle="color: #ff0000;" />
			<li>Seats: <form:input path="seats" /></li>
			<li>Model: <form:select path="model">
					<form:options items="${models}" itemValue="id" itemLabel="modelName" />
				</form:select>
			</li>
			<li>Gear box: <form:select path="gearBox">
					<c:forEach var="gearBox" items="${gearBoxs}">
						<option id="" value="${gearBox}">${gearBox}</option>
					</c:forEach>
				</form:select>
			</li>
			<li>Color: <form:select path="color">
					<c:forEach var="color" items="${colors}">
						<option value="${color}">${color}</option>
					</c:forEach>
				</form:select>
			</li>
			<li>Day price:<form:input path="dayPrice" /></li>
			<li>Upload image:
			     <input type="file" name="file" />   
			        <input type="submit" value="upload" />
		    </li>
		</ul>
		<button type="submit" name="operation" value="new">Save</button>
		
		
	</form:form>
</body>