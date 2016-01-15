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
						<li><h3>${model.modelName}</h3></li>
						<li>Seats: ${model.seats}</li>
						<li>Gear box: ${model.gearBox}</li>
						<li>Day price: ${model.dayPrice}</li>							
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div>
	
	
		