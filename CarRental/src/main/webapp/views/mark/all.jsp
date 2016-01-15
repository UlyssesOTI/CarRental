<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<div class="CarList">
		
		
			<div class="CarResult">
				<table >
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="mark" items="${marks}">
							<tr>
								<td><h4>${mark.id}</h4></td>
								<td><h4>${mark.markName}</h4></td>
								<td>
									<form:form action="editMark" method="post">
										<input type="hidden" name="id" value="${mark.id}">
										<button type="submit">Edit</button>
									</form:form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			
			
			
				
				
					
			</div>		
	</div>
	
	
		