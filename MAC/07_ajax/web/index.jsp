<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>자바스크립트를 이용한 ajax통신</h2>
	<pre>
		비동기식으로 서버와통신하는 기술 'JAVASCRIPT'를 이용해서 
	</pre>
	
	<button onclick = "ajaxTest1()">
		javaScript ajax Test
	</button>
	<div id="target">

	</div>

	<button onclick = "ajaxTest2()">
		javaScript ajax Test _POST
	</button>

<script>
 const ajaxTest1 = () =>{
	 //ajax로 서버와 통신하기
	 // 1.XMLHttpRequest객체 생성하기
	 const xhr = new XMLHttpRequest();
	 
	/* 
	 	2. XMLHttpRequest객체를 설정하기
	 	 	open()함수를 이용해서 통신 값을 세팅한다. 
	 	 		- 1) : 방식 (post? get?)
	 	 		- 2) : url주소 (서블릿 매핑주소)
	 	 	   [- 3) : 동기식, 비동기식 설정] 
	 	>> 백그라운드에서 움직이기 때문에 주소는 안 변하고
	 	클라이언트가 보내는 값을 쿼리스트링으로 전송한다. 
 	*/
 	xhr.open("get","<%=request.getContextPath()%>/ajaxtest.do?id=admin");
	/*
		3. 요청에 대한 서버응답을 처리할 함수를 지정한다. 
		>CALLBACK함수로 받아낸다. 
		xhr객체의 onreadystateonchange 속성에 함수를 대입
		
		xhr내부에 상태를 관리하는 속성이 있다.  > readyState : 전송 상태를 관리한다. (0~4)로 구분함 0: 준비 1:데이터 수집 2:전송 전 3:전송 4:응답 완료(요청 종료)
										> status : 응답 결과 관리 (200, 404, 500, 403)
	*/ 	

	// xhr.onreadystateonchange
	xhr.onreadystatechange=()=>{
		console.log("test1");
		if(xhr.readyState == 4){
			//응답 받음
			console.log("test2");
			if(xhr.status==200){
				//응답메시지를 정상적으로 수신함
				// alert('서버와 통신 완료!');
				// 서버가 응답한 내용은 xhr객체의 responseText라는 속성에 자동으로 대입된다.(그냥 브라우저가 xhr이란 객체를 보내서 그 객체를 이용해서 데이터를 받아온다.)
				console.log(xhr.responseText);
				document.getElementById("target").innerHTML += "<h3>"+xhr.responseText+"</h3>";
			}
			// if(xhr.status==404){
			// 	alert('못 찾겠다 꾀꼬리!');
			// }
		}
	}
	//모든 값에 대해서 설정을 한 뒤 요청을 전송
	xhr.send();
 }

 const ajaxTest2 = () =>{
	 console.log("test1");
	const xhr = new XMLHttpRequest();
	xhr.open("post","<%=request.getContextPath()%>/ajaxtest.do");
	console.log("test2");
	xhr.onreadystatechange=()=>{
		console.log("test3");
		if(xhr.readyState=4){
			console.log("test4");
				if(xhr.status==200){
					console.log("test5");
					console.log(xhr.responseText);
					document.getElementById("target").innerHTML += "<h1>"+xhr.responseText+"</h1>";
				}
		}
	}
	// post방식의 경우에는 데이터를 전송할 경우 url에 데이터 내용을 작성하지 않고,
	// send함수에 매개변수로 작성을 한다. 
	// key:value형식으로 
	
	
	// 전송방식도 수정해야한다.
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencode");
	xhr.send("id=user01");
 }



</script>
</body>
</html>