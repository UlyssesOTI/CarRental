<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="panel">
	<div class="DocumentList">
		<c:forEach var="contract" items="${contracts}">
		
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
       			 			<td><h5>${contract.date}</h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>Begin date: </h3></td>
       			 			<td><h5>${contract.beginDate}</h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>End Date: </h3></td>
       			 			<td><h5>${contract.endDate}</h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>Price: </h3></td>
       			 			<td><h5>${contract.price}</h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>Car info: </h3></td>
       			 			<td><h5>${contract.carInfo}</h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>Reservation info: </h3></td>
       			 			<td><h5>${contract.reservationInfo}</h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td></td>
       			 			<td><form:form action="managerEditContract" method="post">
							<input type="hidden" name="contractId" value="${contract.id}">
							<button type="submit">Edit contract</button>
						</form:form></td>        		        			
        				</tr>
        			</tbody>
					</table>
				
				
			
			
		</c:forEach>
	</div>
		
	</div>
	

	<%-- <div class="CarList">
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
	
		
	</div> --%>