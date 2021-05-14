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
	<h2>xml 데이터 가져오기</h2>
	<button id="xml">xml 데이터 가져오기</button>
	<div id="fiction">
		<h2>소설</h2>
		<table id="fiction_info"></table>
	</div>
	
	<div id="it">
		<h2>프로그래밍</h2>
		<table id="it_info"></table>
	</div>
	
	
	<script>
		$("#xml").click(e=>{
			console.log("test");
			$.ajax({
				url:"books.xml",
				success: data=>{
					let fic_header = $("<tr><th>제목</th><th>저자</th></tr>");
					let it_header = $("<tr><th>제목</th><th>저자</th></tr>");
					console.log(data);
					/* dom */
					let entity = $(data).find(":root");
					console.log(entity);
					/* element */
					let books = $(entity).find("book");
					console.log(books)
					/* element */					
					
					
					
					books.each((i,v)=>{
						let info = "<tr><td>"+$(v).find("title").text()+"</td><td>"+$(v).find("author").text()+"</td></tr>"
						
						if($(v).find("subject").text()=="소설"){
							fic_header+= info;
						} else {
							it_header+=info;
							
						}
						
						
					})
					$("#fiction_info").html(fic_header);
					$("#it_info").html(it_header);
				}
			})
		})
	</script>

</body>
</html>