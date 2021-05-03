<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import = "java.util.*, com.member.model.vo.*"%>
	<!DOCTYPE html>
	<html>
		<head>
		<meta charset="UTF-8">
		<title>회원 정보 출력</title>
		</head>
		<body>
			
			
			<%
			/* 멤버 테이블을 찍어냅니다  */
				List<Member> memberList = (List<Member>) request.getAttribute("members");
						if(memberList != null){
			%>
			<table>
				<caption>회원 테이블</caption>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>PWD</th>
					<th>AGE</th>
				</tr>
				<% 
								for(int i = 0; i< memberList.size(); i++){
				%>
							<tr>
								 <td> <%=memberList.get(i).getMemberId() %> </td> 
								 <td> <%=memberList.get(i).getMemberName() %> </td> 
								 <td> <%=memberList.get(i).getMemberPwd() %> </td> 
								 <td> <%=memberList.get(i).getAge() %> </td> 
							</tr>
							
							
				<%
								}
						}
				%>	
			
			
			</table>
			
			<style>
				table td, th{
					border: 1px black solid;
					border-collapse: collapse;
				}
				
			</style>
			
			
		
		
		</body>
	</html>