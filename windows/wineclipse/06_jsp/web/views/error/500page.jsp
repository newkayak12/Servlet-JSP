<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isErrorPage="true" %>
<!DOCTYPE html>
	<html>
		<head>
		<meta charset="UTF-8">
		<title>Error!</title>
		</head>
		
		<body>
		
			<h3>Error!</h3>
			<h4> Sorry, You has faced Error! </h4>
			<%= exception.getStackTrace() %>
		
		</body>
	</html>