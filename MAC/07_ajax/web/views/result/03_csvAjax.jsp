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
<h2>ajax로 서버에서 데이터만 가져오기 > 데이터 형식이 CSV</h2>
<pre>
	csv : 
	eg
	유병승,19,경기도시흥시,남|김상현,29,서울시구로구,남|김예진,26,서울시강남구,여
	
	이렇게 작성한 것을 '|'로 한 row ','를 column으로 
	나눠서 (특정 문지로 각각의 테이터를 나눌 수 있는 것)
	
	---------------------------------------------------------------
	여튼 다시 돌아와서 
	CSV란? 데이터를 특수기호로 나눠서 표현한 문자열을 의미한다.
	Type은 String 
	
</pre>

<button id="btn" > csv데이터 받아오기 </button>
<div id= "area"> </div>

<script>
	
		
	
	$("#btn").click(e=>{
		$.ajax({
				url:"<%=request.getContextPath()%>/ajax/csvTest.do",
				dataType:"text",
				success:data=>{
					console.log(data);
					const table = $("<table>")
					const members= data.split("\n");
					console.log(members);
					
						for(let i=0; i<members.length; i++){
							let data = members[i].split(",");
							console.log(data);
							let tr =$("<tr>");
							let name = $("<td>").html(data[0]);
							let phone = $("<td>").html(data[1]); 
							let profile = $("<td>").append(  $("<img>").attr({"src":"<%=request.getContextPath()%>/images/"+data[2],"width":"100px","height":"100px" })  );
							tr.append(name).append(phone).append(profile);
							table.append(tr);
						}
					
					$("#area").html(table);
					console.log('test');
					
				}
		})
	})	

	
	
	

</script>


</body>
</html>