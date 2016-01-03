<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Cars:</h3>
	<table class="table-authors">
		<thead>
			<tr>
				<th>regNumber</th>
				<th>regDate</th>
				<th>seats</th>
				<th>gearBox</th>
				<th>color</th>
				<th>dayPrice</th>
				<th>model</th>
				<th>img</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="car" items="${cars}">
				<tr>
					<td>${car.regNumber}</td>
					<td>${car.regDate}</td>
					<td>${car.seats}</td>
					<td>${car.gearBox}</td>
					<td>${car.color}</td>
					<td>${car.dayPrice}</td>
					<td>${car.modelName}</td>
					
					<td><img  src="data:image/jpeg;base64,${car.image}" /></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="createNewCar">Create Car</a>
		