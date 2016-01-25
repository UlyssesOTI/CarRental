<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="panel">
	<form:form action="mSaveContract" method="post" modelAttribute="contract">
		

			<fmt:formatDate value="${contract.beginDate}" pattern="MM/dd/yyyy" var="fbeginDate"/>
			<fmt:formatDate value="${contract.endDate}" pattern="MM/dd/yyyy" var="fendDate"/>
			<fmt:formatDate value="${contract.date}" pattern="MM/dd/yyyy" var="fdate"/>
			
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
       			 			<td><form:input path="date" value ="${fdate}"/></td>        		        			
        				</tr>
       			 		<tr class="success">
       			 			<td><h3>Begin date:</h3></td>
       			 			<td><form:input path="beginDate" value ="${fbeginDate}" readonly="true"/> </td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>End date: </h3></td>
       			 			<td><form:input path="endDate" value ="${fendDate}" readonly="true"/></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td><h3>Sum: </h3></td>
       			 			<td><form:input path="price" readonly="true"/></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Client: </h3></td>
       			 			<td>
       			 				<form:select path="client"> 
									<form:option value="${contract.client.id}" label="${contract.client.lastName} ${contract.client.firstName}" />
					  			</form:select>
					  		</td>        		        			
        				</tr>
        				        				
        				<tr class="success">
       			 			<td><h3>Car: </h3></td>
       			 			<td>
       			 				<form:select path="car"> 
									<c:forEach var="car" items="${cars}">
										<option value="${car.id}"> Reg Number[${car.regNumber}] ${car.modelName}</option>
									</c:forEach>
					  			</form:select></td>        		        			
        				</tr>
        				
        				
        				<tr class="success">
       			 			<td><h3>Reservation: </h3></td>
       			 			<td>
       			 				<form:select path="reservation"> 
									<form:option value="${contract.reservation.id}" label="${contract.reservation.id} ${contract.reservation.summ}" />
					  			</form:select> 
					  		</td>        		        			
        				</tr>
        				
        				
        				<tr >
       			 			<td></td>
       			 			<td><button type="submit" name="operation" value="add">Save</button></td>        		        			
        				</tr>
        			</tbody>
					</table>
			
			<%-- 
			<ul>
						
			<li>beginDate:<form:input path="beginDate" value ="${fbeginDate}" readonly="true"/> </li>
			<li>endDate: <form:input path="endDate" value ="${fendDate}" readonly="true"/></li>
			<li>price: <form:input path="price" /></li>
			<li>client: <form:select path="client"> 
						<form:option value="${contract.client.id}" label="${contract.client.lastName} ${contract.client.firstName}" />
					  </form:select> 
			</li>
			<fmt:formatDate value="${contract.date}" pattern="MM/dd/yyyy" var="fdate"/>
			<li>date: <form:input path="date" value ="${fdate}"/></li>
			<li>car: <form:select path="car"> 
						<c:forEach var="car" items="${cars}">
							<option value="${car.id}">Id[${car.id}] regnumber[${car.regNumber}] ${car.modelName}</option>
						</c:forEach>
					  </form:select>
			</li>
			<li>reservation: <form:select path="reservation"> 
						<form:option value="${contract.reservation.id}" label="${contract.reservation.id} ${contract.reservation.summ}" />
					  </form:select> 
			</li>

		</ul> --%>
		<button type="submit" name="operation" value="add">Save</button>
	</form:form>
</div>