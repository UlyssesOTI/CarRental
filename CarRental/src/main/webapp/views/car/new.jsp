<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div class="panel">
	<form:form action="mNewCar" method="post" modelAttribute="car" enctype="multipart/form-data" >
	<table class="tableClient">
		<thead>
      					<tr>
  			      			<th></th>     			  			
  			      			<th></th>
       					</tr>
    				</thead>
    				<tbody class="tbodyClient">
      			
       			 		<tr class="success">
       			 			<td><h3>Registration Number:</h3></td>
       			 			<td><h5><form:input path="regNumber" /></h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Model: </h3></td>
       			 			<td><h5><form:select path="model">
										<form:options items="${models}" itemValue="id" itemLabel="modelName" />
									</form:select></h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Model: </h3></td>
       			 			<td><h5><form:select path="color">
										<c:forEach var="color" items="${colors}">
												<option value="${color}">${color}</option>
										</c:forEach>
									</form:select>
								</h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td></td>
       			 			<td><button type="submit" name="operation" value="new">Save</button></td>        		        			
        				</tr>
        				  				
        			</tbody>
					</table>
	
	</form:form>
</div>









<%-- 	<form:form action="mNewCar" method="post" modelAttribute="car" enctype="multipart/form-data" >
		<ul>
			<li>Registration Number: <form:input path="regNumber" /></li>
			<form:errors  path="regNumber" cssStyle="color: #ff0000;" />
			<li>Model: <form:select path="model">
					<form:options items="${models}" itemValue="id" itemLabel="modelName" />
				</form:select>
			</li>
			<li>Color: <form:select path="color">
					<c:forEach var="color" items="${colors}">
						<option value="${color}">${color}</option>
					</c:forEach>
				</form:select>
			</li>
		</ul>
		<button type="submit" name="operation" value="new">Save</button>
		
		
	</form:form>
 --%>