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
<h2>ajax를 이용한 자동완성 구현하기</h2>
<input id="keyword" list="list" placeholder="찾을 이름을 작성하세요">
<datalist id="list">
	
</datalist>

<script>
	$("#keyword").keyup(e=>{
		$.ajax({
			url: "<%=request.getContextPath()%>/ajax/search.do",
			data : {"keyword":$("#keyword").val()},
			success:data=>{
				$("#list").html("");
				 let names = data.split(",");
				 
					$.each(names,(i,v)=>{
						let op = $("<option>").attr("value",v).html(v)
						$("#list").append(op);
						
					})
				
				
			}
			
		})
		
		
		
	});
</script>

</body>
</html>