<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="panel">
<c:forEach var="model" items="${models}">

<table class="tableClient">
					<thead>
      					<tr>
  			      			<th></th>     			  			
  			      			<th></th>
       					</tr>
    				</thead>
    				<tbody class="tbodyClient">
      			
       			 		<tr class="success">
       			 			<td><h3>Image:</h3></td>
       			 			
       			 			<td><img 	src='<c:url value="${model.imageURL}"></c:url>'  height="150" width="250"/></td>
       			 			<%-- <td><img 	src="${model.imageURL}"  height="150" width="250"/></td>  --%>
       			 			
       			 			
       			 			<%-- <td><h5><img  src="data:image/jpeg;base64,${model.image}" height="150" width="250"/></h5></td>         --%>		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>${model.markName}</h3></td>
       			 			<td><h3>${model.modelName}</h3></td>        		        			
        				</tr>
        				
        				
        				
        				<tr class="success">
       			 			<td><h3>Seats: </h3></td>
       			 			<td><h5>${model.seats}</h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>Gearbox: </h3></td>
       			 			<td><h5>${model.gearBox}</h5></td>        		        			
        				</tr>
        				
        				       
        				<tr class="success">
       			 			<td><h3>Day price:</h3></td>
       			 			<td><h5> ${model.dayPrice}</h5></td>        		        			
        				</tr>
        				
        				
        				<tr class="success">
       			 			<td></td>
       			 			<td><form:form action="mEditModel" method="post">
							<input type="hidden" name="id" value="${model.id}">
							<button type="submit">Edit</button>
						</form:form>	</td>        		        			
        				</tr>
        				
        				
        			</tbody>
					</table>
				
</c:forEach>
</div>


	
<%-- 
	<div class="CarList">
		<c:forEach var="model" items="${models}">
		
			<div class="CarResult">
				
				<div class="CarResultDetail">
				
					<h4 class="headerCarList">
						<img  src="data:image/jpeg;base64,${model.image}" height="150" width="250"/>
					</h4>
					<ul>
						<li><h3>${model.markName}</h3></li>
						<li><h3>${model.modelName}</h3></li>
						<li>Seats: ${model.seats}</li>
						<li>Gear box: ${model.gearBox}</li>
						<li>Day price: ${model.dayPrice}</li>	
						<form:form action="mEditModel" method="post">
							<input type="hidden" name="id" value="${model.id}">
							<button type="submit">Edit</button>
						</form:form>						
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div>
	 --%>
	
		