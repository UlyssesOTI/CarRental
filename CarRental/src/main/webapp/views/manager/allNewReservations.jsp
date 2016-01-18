<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



	

	<div class="CarList">
		<c:forEach var="model" items="${models}">
		
			<div class="CarResult">
				
				<div class="CarResultDetail">
				
					<h4 class="headerCarList">
						<img  src="data:image/jpeg;base64,${model.image}" height="150" width="250"/>
					</h4>
					<ul>
						<li><h3>${reservations.markName}</h3></li>
						<li><h3>${reservations.modelName}</h3></li>
						<li>Seats: ${reservations.seats}</li>
						<li>Gear box: ${reservations.gearBox}</li>
						<li>Day price: ${reservations.dayPrice}</li>	
						<form:form action="managerEditModel" method="post">
							<input type="hidden" name="id" value="${reservations.id}">
							<button type="submit">Create contract</button>
						</form:form>						
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div>
	
	
		