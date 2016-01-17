<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker1" ).datepicker();
  });
  $(function() {
	    $( "#datepicker2" ).datepicker();
	  });
  </script>
</head>
	

</head>
<body>
	<form action="allClientsAvailableModels" method="post">
		<h2>Input Data</h2>
			<p>Pick-Up Date: <input type="text" id="datepicker1" name="begin"></p>
			<p>Drop-Off Date: <input type="text" id="datepicker2" name="end"></p>
		<button type="submit">Submit</button>
	</form>
	
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
						<form:form action="clientReserveModel" method="post">
							<input type="hidden" name="id" value="${model.id}">
							<button type="submit">Reserve</button>
						</form:form>						
					</ul>
					
				</div>
				
			</div>		
			
		</c:forEach>
	
		
	</div>


	

</body>
</html>