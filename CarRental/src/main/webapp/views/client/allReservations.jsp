<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="CarList">
		<c:forEach var="reservation" items="${reservations}">
		
			<div class="CarResult">
				
				<div class="CarResultDetail">
					<ul>
						<li>Date: ${reservation.date}</li>
						<li><h3>${reservation.modelName}</h3></li>
						<li>Client last name: ${reservation.clientLastName}</li>
						<li>Client first name: ${reservation.clientFirstName}</li>
						<li>Begin date: ${reservation.beginDate}</li>
						<li>End date: ${reservation.endDate}</li>
						<li>Sum: ${reservation.summ}</li>	
						<c:if test="${reservation.contractId =='0'}">
							<form:form action="clientDiscardReservation" method="post">
							<input type="hidden" name="id" value="${reservation.id}">
							<button type="submit">Discard reservation</button>
						</form:form>	
						</c:if>
											
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div>