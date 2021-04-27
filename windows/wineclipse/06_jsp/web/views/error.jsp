<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "false" %>
<!DOCTYPE html>
	<html>
		<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		</head>
		
		<body>
			<h1 style="color: red;"> Oops! XD</h1>
			<%-- <h3><%=exception.getMessage() %> Error has been faced</h3> --%>
			<h3><a href="<%=request.getContextPath()%>">메인으로</a></h3>
			
		</body>
	</html>