<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>내장 객체 출력하기</h1>
	<h2> <%=request %> </h2>
	<h2> <%=session %></h2>
	<h2> <%=application %></h2>
	<h2> <%=response %></h2>
	<%-- <h2> <%=myObj %></h2> --%>
	
	<h1>내장 객체 사용하기</h1>
	<% 	
		request.setAttribute("hobby", new String[] {"코딩","정처기","운동","다도","영화"});
		session.setAttribute("userId", "sanghyeon");
		application.setAttribute("email", "newkayak12@gmail.com");
		
		RequestDispatcher rd = request.getRequestDispatcher("/");
		rd.forward(request, response);
		
		
		
		
		//response.sendRedirect(request.getContextPath()+"/"); 
	%>
	
</body>
</html>