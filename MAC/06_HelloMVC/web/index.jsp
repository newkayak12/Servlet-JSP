<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 해더파일불러오기 -->
<%@ include file="views/common/header.jsp" %>
<section id="content">
	<h1 align="center" style="margin:200px;">안녕하세요,mvc입니다.</h1>
	
	<button onclick="fn_ajaxTest()"> 정보 받기 </button>
	<div id="result">
	
	</div>
</section>
<script>

const fn_ajaxTest=()=>{
	console.log("test1");
	const xhr= new XMLHttpRequest();
	console.log("test2");
	const userId = document.getElementById("userId").value;
	const password = document.getElementById("password").value;
	xhr.open("get","<%=request.getContextPath()%>/memberInfo?userId="+userId+"&password="+password);
	console.log("test3");

	
	xhr.onreadystatechange=()=>{
		console.log("test4");
		if(xhr.readyState==4){
			console.log("test5");
			if(xhr.status==200){
				console.log("test6");
				document.getElementById("result").innerHTML=xhr.responseText;
			}
		}
	}
	
	xhr.send();
}

</script>

<%@ include file="views/common/footer.jsp" %>