<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="panel">
	<form:form action="mSaveModel" method="post" modelAttribute="model" enctype="multipart/form-data" >
	<form:input path="id" type="hidden"/>
	<table class="tableClient">
		<thead>
      					<tr>
  			      			<th></th>     			  			
  			      			<th></th>
       					</tr>
    				</thead>
    				<tbody class="tbodyClient">
      			
       			 		<tr class="success">
       			 			<td><h3>Name: </h3></td>
       			 			<td><h5> <form:input path="modelName" /></h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Mark: </h3></td>
       			 			<td><form:select path="mark">
										<form:options items="${marks}" itemValue="id" itemLabel="markName" />
									</form:select>      		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Seats: </h3></td>
       			 			<td><h5> <form:input path="seats" /></h5></td>        		        			
        				</tr>
        				
        				
        				<tr class="success">
       			 			<td><h3>Gear box:</h3></td>
       			 			<td><h5><form:select path="gearBox">
										<c:forEach var="gearBox" items="${gearBoxs}">
											<option id="" value="${gearBox}">${gearBox}</option>
										</c:forEach>
									</form:select>
								</h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Day price:</h3></td>
       			 			<td><h5> <form:input path="dayPrice" /></h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Upload image:</h3></td>
       			 			<td><h5> <input type="file" name="file" /></h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td></td>
       			 			<td><button type="submit" name="operation" value="update">Save</button></td>        		        			
        				</tr>
        				  				
        			</tbody>
					</table>
	
	</form:form>
</div>








	<%-- <form:form action="mSaveModel" method="post" modelAttribute="model" enctype="multipart/form-data" >
		<ul>
			<li>ID<form:input path="id" readonly="true"/></li>
			<li>Name: <form:input path="modelName" /></li>
			<li>Mark: <form:select path="mark">
					<form:options items="${marks}" itemValue="id" itemLabel="markName"/>
				</form:select>
			</li>
			<li>Seats: <form:input path="seats" /></li>
			<li>Gear box: <form:select path="gearBox" >
					<c:forEach var="gearBox" items="${gearBoxs}">
						<option id="" value="${gearBox}">${gearBox}</option>
					</c:forEach>
				</form:select>
			</li>
			<li>Day price:<form:input path="dayPrice" /></li>
			<li>Upload image:
			     <input type="file" name="file" />   
			        <input type="submit" value="upload" />
		    </li>
			
		</ul>
		<button type="submit" name="operation" value="update">Save</button>
	</form:form>
 --%>





