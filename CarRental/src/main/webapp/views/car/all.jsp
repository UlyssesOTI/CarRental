<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



	

	<div class="CarList">
		<c:forEach var="car" items="${cars}">
		
			<div class="CarResult">
				
				<div class="CarResultDetail">
				
					<h4 class="headerCarList">
						<img  src="data:image/jpeg;base64,${car.image}" height="150" width="250"/>
					</h4>
					<ul>
						<li><h3>${car.modelName}</h3></li>
						<li>Reg number: ${car.regNumber}</li>
						<li>Reg date: ${car.regDate}</li>
						<li>Seats: ${car.seats}</li>
						<li>Gearbox: ${car.gearBox}</li>
						<li>Color: ${car.color}</li>
						<li>Day price: ${car.dayPrice}</li>
						
						
						
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div>
	
	
		