<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<form action="showAllCars" method="post" enctype="multipart/form-data" >
		
		<ul>
						<li>regNumber: <input type="text" name="regNumber"></li>
						<li>regDate: <input type="text" name="regDate"></li>
						<li>seats: <input type="text" name="seats"></li>
						<li>model: 
							<form:select path="model">
							<form:options items="${model}" itemValue="id" itemLabel="modelName"/>
							</form:select>
						<li>gearBox
							<select name="gearBox">
								<c:forEach var="gb" items="${gearBox}">
									<option value="${gb.name()}">${gb.name()}</option>
								</c:forEach>
							</select>
						</li>
						<li>color
							<select name="color">
								<c:forEach var="c" items="${color}">
									<option value="${c.name()}">${c.name()}</option>
								</c:forEach>
							</select></li>
						<li>Upload image:
					      <input type="file" name="file" />
					      
				          <input type="submit" value="upload" /></li>
						
						<li>dayPrice: <input type="text" name="dayPrice"></li>
						
					</ul>
		
		<button type="submit">Save</button>
	</form>
</body>