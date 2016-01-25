<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="panel">
	<form:form action="mSaveMark" method="post" modelAttribute="mark">
	<table class="tableClient">
		<thead>
      					<tr>
  			      			<th></th>     			  			
  			      			<th></th>
       					</tr>
    				</thead>
    				<tbody class="tbodyClient">
      			
       			 		<tr class="success">
       			 			<td><h3>Mark name: </h3></td>
       			 			<td><h5> <form:input path="markName" /></h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td></td>
       			 			<td><button type="submit" name="operation" value="add">Save</button></td>        		        			
        				</tr>
	</tbody>
	</table>
	
	<%-- 	<ul>
			<li>Mark name: <form:input path="markName" /></li>		
		</ul>
		<button type="submit" name="operation" value="add">Save</button> --%>
	</form:form>
</div>