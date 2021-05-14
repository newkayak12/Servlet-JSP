<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h2> 서버에 있는 텍스트 파일 내용 읽어오기</h2>
	<button id = "testAjax">실행하기</button>
	<div id="area"></div>
	
	<script>
		$(function(){
			$("#testAjax").click(e=>{
					$.ajax({
						url:"sample.txt",
	/* 					요청할 주소 */
	
						type:"get",
						
						/* 요청 방식 */
						
						//data:, 
						//parameter 서버에 전송하는 값(js객체로 대입)
					
						dataType:"text",
						//응답 받는 데이터의 타입 지정(지정하지 않아도 자동으로 설정됨)
						
						success:data=>{console.log(data);
						$("#area").html(data);
						},
						//서버와 통신이 종료 후 정상적으로 완료된 후 실행되는 함수 > 매개변수에 서버가 보낸 값이 대입됨
						
						//error:,
						//서버와 통신이 정상적으로 완료되지 못한 경우
						
						//complete:
						//무조건 실행하는...
						
					})
			})
			
		})
		
		
	</script>
	
	
</body>
</html>