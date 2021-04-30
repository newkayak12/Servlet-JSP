<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String msg = (String)request.getAttribute("msg"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "/js/jqeury-3.6.0.min.js"></script>
</head>
<body>


<script>
	alert("<%= msg %>");
	location.replace('<%=request.getContextPath()%><%=request.getAttribute("loc")%>');
</script>



</body>
</html>