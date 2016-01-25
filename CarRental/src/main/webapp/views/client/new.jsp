<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="panel">
	<form:form action="newClient" method="post" modelAttribute="client" enctype="multipart/form-data" >
	
	
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
       			 			<td><h5><form:input path="lastName" /></h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>First name: </h3></td>
       			 			<td><h5><form:input path="firstName" /></h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>login: </h3></td>
       			 			<td><h5><form:input path="email" /></h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>Password: </h3></td>
       			 			<td><h5> <form:input path="password" /></h5></td>        		        			
        				</tr>
        				
        				<tr >
       			 			<td></td>
       			 			<td><button type="submit" name="operation" value="add">Save</button></td>        		        			
        				</tr>
        			</tbody>
					</table>
	
	
	
	
	
		<%-- <ul>
			
			<li>lastName: <form:input path="lastName" /></li>
			<li>Name: <form:input path="firstName" /></li>
			<li>email: <form:input path="email" /></li>
			<li>password: <form:input path="password" /></li>
			
		</ul> --%>
		
	</form:form>
</div>
