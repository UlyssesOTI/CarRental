<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



	

	<div class="CarList">
		<c:forEach var="contract" items="${contracts}">
		
			<div class="CarResult">
				
				<div class="CarResultDetail">
					<ul>
						<li><h3>${contract.id}</h3></li>
						<li>Date: ${contract.date}</li>
						<li>endDate: ${contract.beginDate}</li>
						<li>endDate: ${contract.endDate}</li>
						<li>price: ${contract.price}</li>
						<li>clientInfo: ${contract.clientInfo}</li>
						<li>carInfo: ${contract.carInfo}</li>
						<li>reservationInfo: ${contract.reservationInfo}</li>
							
						<form:form action="managerEditContract" method="post">
							<input type="hidden" name="contractId" value="${contract.id}">
							<button type="submit">Edit contract</button>
						</form:form>						
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div>