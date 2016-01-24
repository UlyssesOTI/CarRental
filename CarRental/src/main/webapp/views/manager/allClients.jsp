<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
						<form:form action="managerClientContracts" method="post">
							<input type="hidden" name="id" value="${client.id}">
							<button type="submit">All contracts</button>
						</form:form>						
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div>