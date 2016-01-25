<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




<div class="panel">
	<div class="DocumentList">
		<c:forEach var="client" items="${clients}">
		
			<table class="tableClient">
					<thead>
      					<tr>
  			      			<th></th>     			  			
  			      			<th></th>
       					</tr>
    				</thead>
    				<tbody class="tbodyClient">
      			
       			 		<tr class="success">
       			 			<td><h3>Last name: </h3></td>
       			 			<td><h5>${client.lastName}</h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>First Name: </h3></td>
       			 			<td><h5>${client.firstName}</h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>Login: </h3></td>
       			 			<td><h5>${client.email}</h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>Registration Date: </h3></td>
       			 			<td><h5>${client.regDate}</h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3></h3></td>
       			 			<td>
       			 				<form:form action="mClientContracts" method="post">
									<input type="hidden" name="id" value="${client.id}">
									<button type="submit">All contracts</button>
								</form:form>
							</td>        		        			
        				</tr>
        			</tbody>
					</table>
				
				
			
			
		</c:forEach>
	</div>
		
	</div>
















	<div class="CarList">
		<c:forEach var="client" items="${clients}">
		
			<div class="CarResult">
				
				<div class="CarResultDetail">
					<ul>
						<li><h3>${client.id}</h3></li>
						<li>Last name: ${client.lastName}</li>
						<li>First Name: ${client.firstName}</li>
						<li>Email: ${client.email}</li>
						<li>regDate: ${client.regDate}</li>												
						<form:form action="mClientContracts" method="post">
							<input type="hidden" name="id" value="${client.id}">
							<button type="submit">All contracts</button>
						</form:form>						
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div>