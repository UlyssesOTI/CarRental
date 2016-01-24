<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="cSaveReservation" method="post" modelAttribute="reservation" >
		<ul>
			<fmt:formatDate value="${reservation.beginDate}" pattern="MM/dd/yyyy" var="fbeginDate"/>
			<fmt:formatDate value="${reservation.endDate}" pattern="MM/dd/yyyy" var="fendDate"/>
			<li>beginDate:<form:input path="beginDate" value ="${fbeginDate}" readonly="true"/> </li>
			<li>endDate: <form:input path="endDate" value ="${fendDate}" readonly="true"/></li>
			<li>summ: <form:input path="summ" /></li>
			<li>model: <form:select path="model"> 
							<option value="${reservation.model.id}"> ${reservation.model.modelName}</option>
					   </form:select>
			</li>
			<li>client: <form:select path="client"> 
						<form:option value="${reservation.client.id}" label="${reservation.client.lastName} ${reservation.client.firstName}" />
					  </form:select> 
			</li>	
		</ul>
		<button type="submit" name="operation" value="add">Save</button>
	</form:form>

</body>
</html>