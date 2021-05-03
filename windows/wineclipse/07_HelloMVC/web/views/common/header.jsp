

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.common.listener.LoginCheckListener"%>
<%@ page import = "com.member.model.vo.Member"%>
    
 
 
 <%
 	Member m = (Member) session.getAttribute("member");
 	Cookie[] getCookies = request.getCookies();
 	String saveId = null;
 			if(getCookies != null){
		 			for(Cookie c  :  getCookies){
						if(c.getName().equals("saveId")){
								saveId = c.getValue();
						}
		 			}
 			}	

 %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>PAGE</title>
			
			<link rel="stylesheet" type ="text/css" href="css/style.css"> 
			<script src = "<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
		</head>
		<body>
			<div id = "container">
				<header>
					<h1> Hello MVC</h1>
					<div class="login-container">
					
					<%-- <%=request.getContextPath() %> --%>
					<% if (m == null){  System.out.println(request.getContextPath());%>
					
						<form action="<%=request.getContextPath()%>/login" method="POST" id= "loginFrm" onsubmit = "return fn_login_validate();">
							<table>
								<tr>
									<td><input type="text" name="userId" id="userId" placeholder ="id" value="<%=saveId!=null? saveId : ""%>"></td>
									<td></td>
								</tr>
								<tr>
									<td><input type="password" name="pwd" id="pwd" placeholder ="pw"></td>
									<td><input type="submit"  value ="login"></td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="checkbox" name ="saveId" id="saveId" <%= saveId != null? "checked" : "" %>>
										<label for ="saveId">아이디 저장</label>
										<input type = "button" value = "회원가입" onclick = "location.replace('<%=request.getContextPath()%>/memberenroll.do')">
										
									</td>
								</tr>
								
								
								
							</table>
						</form>
					<% } else{ %>
						
						<table id="logged-in">
							<tr>
								<td><%= m.getUserName() %>님, 환영합니다!</td>
								<td>현재 접속자 수 : <%=LoginCheckListener.getCount() %></td>
							</tr>
							<tr>
								<td><input type="button" value="내정보 보기" onclick = ""></td>
								<td><input type="button" value="sign out" onclick="location.replace('<%=request.getContextPath()%>/logout')"> </td>
								
							</tr>
							
							
						</table>
						
						
						<% }%>
					
					</div>
					
					<nav>
						<ul class = "main-nav">
							<li class="home"> <a href = ""> HOME </a> </li>
							<li class="Notice"> <a href = ""> notice </a> </li>
							<li class="Board"> <a href = ""> board </a> </li>
						</ul>
					</nav>
				</header>
				
				
				<script>
					const fn_login_validate = ()=>{
						const userId =$("#userId").val();
							if(userId.trim().length<4){
								
								alert('ID를 4글자 이상 입력하세요');
								return false;
							}
						
						const pwd = $("#pwd").val().trim();
							if(pwd.length==0){
								alert('비밀번호를 입력하세요')
								
								return false;
							}
						
					}
					
					
					
					
				</script>