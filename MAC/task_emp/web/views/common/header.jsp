<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/script.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<header>
	<div id="header-container">
		<span>
			<span>
				<a href = "<%=request.getContextPath()%>/">SHOP</a>
			</span>
			<span>
				<a href = "<%=request.getContextPath()%>/">BOARD</a>
			</span>
			<span>
				<a href = "<%=request.getContextPath()%>/">REVIEW</a>
			</span>
		</span>
		<span>
			<span><a href="<%=request.getContextPath()%>/">LOGO</a></span>
		</span>
		
		<span>
			<span>
				<a href="">SIGN IN</a>
			</span>

			<span>
				<a href="">MY PAGE</a>
			</span>
		</span>
	</div>
	</header>
