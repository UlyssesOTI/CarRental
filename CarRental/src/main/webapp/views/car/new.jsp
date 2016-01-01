<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<form action="showAllCars" method="post">
		regNumber: <input type="text" name="regNumber">
		regDate: <input type="text" name="regDate">
		seats: <input type="text" name="seats">
		model: 
		<select name="modelid">
			<c:forEach var="model" items="${model}">
				<option value="${model.id}">${model.modelName}</option>
			</c:forEach>
		</select>
		gearBox
		<select name="gearBox">
			<c:forEach var="gb" items="${gearBox}">
				<option value="${gb.name()}">${gb.name()}</option>
			</c:forEach>
		</select>
		color
		<select name="color">
			<c:forEach var="c" items="${color}">
				<option value="${c.name()}">${c.name()}</option>
			</c:forEach>
		</select>
   		
	
		dayPrice: <input type="text" name="dayPrice">
		
		<button type="submit">Save</button>
	</form>
</body>