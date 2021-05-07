<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import =  "com.member.model.vo.*" %>    
    
<%@ include file="/views/common/header.jsp"%>    
    
<style type="text/css">
    section#memberList-container {text-align:center;}
    
    section#memberList-container table#tbl-member {width:100%; border:1px solid gray; border-collapse:collapse;}
    section#memberList-container table#tbl-member th, table#tbl-member td {border:1px solid gray; padding:10px; }
    div#pageBar *{text-decoration: none; color: black; margin-right: 20px; }
    div#pageBar span { font-weight : bolder;}
    </style>
    
    <section id="memberList-container">
        <h2>회원관리</h2>
        <table id="tbl-member">
            <thead>
                <tr>
                
                
                    <th>아이디</th>
				    <th>이름</th>
				    <th>성별</th>
				    <th>나이</th>
				    <th>이메일</th>
				    <th>전화번호</th>
				    <th>주소</th>
				    <th>취미</th>
				    <th>가입날짜</th>
				    
				    
				    
                </tr>
            </thead>
            <tbody>
            
            <%
            List<Member> result = ( List<Member> )request.getAttribute("list");
               
            if(result.size() >0){
                	for(Member m : result){
              
                  %> 
                  
                  <!--  -->
       			<tr>
       				<td><%=m.getUserId()%></td>
       				<td><%=m.getUserName()%></td>
       				<td><%=m.getGender()%></td>
       				<td><%=m.getAge()%></td>
       				<td><%=m.getEmail()%></td>
       				<td><%=m.getPhone()%></td>
       				<td><%=m.getAddress()%></td>
       				<td><%=m.getHobby()%></td>
       				<td><%=m.getEnrollDate()%></td>
       	
 				</tr>      	
	    
	   		 <%	
   		 			} 
             } else { %>
            	 
            	<p> 결과가 없습니다. </p> 
            	 
            <%  }%>
            </tbody>
        </table>
   			<div id = "pageBar"> <%= request.getAttribute("pageBar") %></div>
    </section>
    
    
    
    <%@ include file="/views/common/footer.jsp"%>