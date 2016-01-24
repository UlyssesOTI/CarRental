<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<form:form action="mSaveModel" method="post" modelAttribute="model" enctype="multipart/form-data" >
		<ul>
			
			<li>Name: <form:input path="modelName" /></li>
			<li>Mark: <form:select path="mark">
					<form:options items="${marks}" itemValue="id" itemLabel="markName" />
				</form:select>
			</li>
			<li>Seats: <form:input path="seats" /></li>
			<li>Gear box: <form:select path="gearBox">
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
		<button type="submit" name="operation" value="add">Save</button>
	</form:form>
</body>