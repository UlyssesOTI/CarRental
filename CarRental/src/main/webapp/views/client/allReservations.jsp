<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel">
<c:forEach var="reservation" items="${reservations}">

<table class="tableClient">
					<thead>
      					<tr>
  			      			<th></th>     			  			
  			      			<th></th>
       					</tr>
    				</thead>
    				<tbody class="tbodyClient">
      			
       			 		<tr class="success">
       			 			<td><h3>Date: </h3></td>
       			 			<td><h5>${reservation.date}</h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Model: </h3></td>
       			 			<td><h5>${reservation.modelName}</h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Client last name: </h3></td>
       			 			<td><h5>${reservation.clientLastName}</h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Client first name: </h3></td>
       			 			<td><h5>${reservation.clientFirstName}</h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Begin date: </h3></td>
       			 			<td><h5>${reservation.beginDate}</h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>End Date: </h3></td>
       			 			<td><h5>${reservation.endDate}</h5></td>        		        			
        				</tr>
        				
        				
        				
        				<tr class="success">
       			 			<td><h3>Sum: </h3></td>
       			 			<td><h5>${reservation.summ}</h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td></td>
       			 			<td><c:if test="${reservation.contractId =='0'}">
							<form:form action="cDiscardReservation" method="post">
							<input type="hidden" name="id" value="${reservation.id}">
							<button type="submit">Discard reservation</button>
						</form:form>
				</c:if></td>        		        			
        				</tr>
        			</tbody>
					</table>
				
</c:forEach>
</div>
<%-- <div class="CarList">
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
							<form:form action="cDiscardReservation" method="post">
							<input type="hidden" name="id" value="${reservation.id}">
							<button type="submit">Discard reservation</button>
						</form:form>	
						</c:if>
											
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div> --%>