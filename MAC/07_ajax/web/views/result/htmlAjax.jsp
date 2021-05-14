<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<!-- ajax를 통해서 서버에 요청해보기! HTML파일을 받아올 수도 있다. -->
	<h3> html 파일을 ajax로 받아오기</h3>
<!-- 결국에는 out으로 html코드를 보내는 것 -->
	<button id="htmlAjax">html받아오기</button>
	<div id="area"></div>


	<script>
	$(function(){
		$("#htmlAjax").click(e=>{
			$.ajax({
				url: "<%=request.getContextPath()%>/ajax/htmlTest.do",
				type:"get",
				dataType:"html",
				success:data=>{
					console.log(data);
					$("#area").html(data);
				}
				
				
			})
		})
		
	})
	
	</script>

</body>
</html>