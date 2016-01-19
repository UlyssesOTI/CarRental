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
	<form:form action="managerSaveContract" method="post" modelAttribute="contract">
		<ul>

			<fmt:formatDate value="${contract.beginDate}" pattern="MM/dd/yyyy" var="fbeginDate"/>
			<fmt:formatDate value="${contract.endDate}" pattern="MM/dd/yyyy" var="fendDate"/>
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

		</ul>
		<button type="submit" name="operation" value="add">Save</button>
	</form:form>
</body>
</html>