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
        			</tbody>
					</table>
				
				
			
			
		</c:forEach>
	</div>
		
	</div>