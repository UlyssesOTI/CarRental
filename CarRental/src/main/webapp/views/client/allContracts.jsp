<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



	

	<div class="CarList">
		<c:forEach var="contract" items="${contracts}">
		
			<div class="CarResult">
				
				<div class="CarResultDetail">
					<ul>
						<li>Date: ${contract.date}</li>
						<li>beginDate: ${contract.beginDate}</li>
						<li>endDate: ${contract.endDate}</li>
						<li>price: ${contract.price}</li>
						<li>carInfo: ${contract.carInfo}</li>
						<li>reservationInfo: ${contract.reservationInfo}</li>					
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div>