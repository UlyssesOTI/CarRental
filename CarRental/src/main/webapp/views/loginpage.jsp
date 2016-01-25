<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="panel">
<form action="loginprocessing" method="post">
	<table class="tableClient">
		<thead>
      					<tr>
  			      			<th></th>     			  			
  			      			<th></th>
       					</tr>
    				</thead>
    				<tbody class="tbodyClient">
      			
       			 		<tr class="success">
       			 			<td><h3>Login: </h3></td>
       			 			<td><h5><input type="text" name="username"> </h5></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td><h3>Password: </h3></td>
       			 			<td><h5><input type="password" name="password"> </h5></td>        		        			
        				</tr>
        				<tr class="success">
       			 			<td></td>
       			 			<td><input type="submit" value="Login"></td>        		        			
        				</tr>
        				
        				<tr class="success">
       			 			<td></td>
       			 			<td><a href="signIn">Sign up</a></td>        		        			
        				</tr>
	</tbody>
	</table>
</form>
	<!-- <form action="loginprocessing" method="post">
		Login <input type="text" name="username">
		Password <input type="password" name="password">
		<input type="submit" value="Login">
	</form>
	
	<a href="signIn">Sign in</a> -->
</div>
</body>
</html>