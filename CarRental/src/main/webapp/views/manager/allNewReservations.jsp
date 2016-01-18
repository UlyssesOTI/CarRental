<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



	

	<div class="CarList">
		<c:forEach var="reservation" items="${reservations}">
		
			<div class="CarResult">
				
				<div class="CarResultDetail">
					<ul>
						<li><h3>${reservation.id}</h3></li>
						<li>Date: ${reservation.date}</li>
						<li><h3>${reservation.modelName}</h3></li>
						<li>Client last name: ${reservation.clientLastName}</li>
						<li>Client first name: ${reservation.clientFirstName}</li>
						<li>Begin date: ${reservation.beginDate}</li>
						<li>End date: ${reservation.endDate}</li>
						<li>Sum: ${reservation.summ}</li>
							
						<form:form action="managerCreateContract" method="post">
							<input type="hidden" name="resrvationId" value="${reservation.id}">
							<input type="hidden" name="clientId" value="${reservation.clientId}">
							<input type="hidden" name="modelId" value="${reservation.modelId}">
							<button type="submit">Create contract</button>
						</form:form>						
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div>
	
	
		