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

<h2> JSON으로 받아보기 _ JAVASCRIPT_OBJECT_NOTATION</h2>
<pre>
	서버의 응답 내용이 js의 OBJECT로 받아지는 것 
</pre>

<button id="basicjson">기본 JSON으로 받아오기</button>
<div id="area"></div>

<button id="listjson">list 형식의 객체 가져오기</button>
<input type="text" id="names">
<div id="listarea"></div>

<script>
$("#names").keyup(e=>{
	$.ajax({
		url:"<%=request.getContextPath()%>/json/listData",
		data:{"keyword": $("#names").val()},
		success:data=>{
			
			console.log(data+"!")
			const table =$("<table>");
			const header =$("<tr>").append($("<th>").html("아이디")).append($("<th>").html("이름")).append($("<th>").html("나이")).append($("<th>").html("이메일"));
			table.html(header);
			for(let i =0; i<data.length; i++){
				
				let user = data[i];
				let tr = $("<tr>").append($("<td>").html(user["userId"])).append($("<td>").html(user["userName"])).append($("<td>").html(user["age"])).append($("<td>").html(user["email"]))
				table.append(tr);
			}
			
			$("#listarea").html(table);
		}
		
	})
	
	
	
})



$("#basicjson").click(e=>{
	$.ajax({
			url:"<%=request.getContextPath()%>/json/basicData",
			dataType:"json",
			success:data=>{
				console.log(data);
				const ul =$("<ul>");
				let li1 = $("<li>").html(data["name"])
				let li2 = $("<li>").html(data["phone"])
				let li3 = $("<li>").html($("<img>").attr({
					"src": '<%=request.getContextPath()%>/images/'+data["profile"],
					"height":"100px",
					"width" : "100px"
				}))
				let li4 = $("<li>").html(data["age"])
				let li5 = $("<li>").html(data["height"])
				ul.append(li1).append(li1).append(li2).append(li3).append(li4).append(li5);
				$("#area").html(ul);
				console.log("test");
			}
	})
})

</script>
</body>
</html>