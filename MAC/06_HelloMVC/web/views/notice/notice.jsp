<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%> 
<%@ page import = "com.notice.model.vo.Notice" %>
<%@ page import = "java.util.*" %>

<style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse;}
    table#tbl-notice th, table#tbl-notice td {border:1px solid; padding: 5px 0; text-align:center;}
    div#pageBar{display:flex; justify-content: center;} 
    a{text-decoration: none;color: black;   }
</style>



<section id="notice-container">
        <h2>공지사항</h2>
        <table id="tbl-notice">
            <tr>
            
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>첨부파일</th>
                <th>작성일</th>
            </tr>
            
            <%List<Notice> result = (List<Notice>) request.getAttribute("result");
            	if(result!= null && result.size()>0){
            		for(Notice notice :result){
            			%>
       			<tr>
       				<td><%=notice.getNoticeNo() %></td>
       				<td>
       				
       					<a href ="<%=request.getContextPath()%>/notice/noticedetail?notice_no=<%=notice.getNoticeNo() %>&notice_writer=<%=notice.getNoticeWriter() %>"  target="_blank"><%=notice.getNoticeTitle() %></a>
      				
      				</td>
       				<td><%=notice.getNoticeWriter() %></td>
       				<td>
		       				<%if(notice.getFilepath() != null){%>
		       				
		       						<img alt="" src="<%=request.getContextPath()%>/images/<%=notice.getFilepath()%>" width="16px" height="16px">
		       				
		       				<% } else {%>
		       				
		       						<span>NO_IMAGE</span>
		       				
		       				<%} %>
       				</td>
       				<td><%=notice.getNoticeDate() %></td>
       			
       			
       			</tr>
            			
            			
            			
            			
            			<%
            		}
            	}
            %>
            
	<!-- 내용출력할것
	첨부파일 있으면 이미지, 없으면 공란으로 표시
	이미지파일은 web/images/file.png에 저장 -->
        </table>
    </section>


<div id="pageBar">
	<%=request.getAttribute("pageBar") %>
</div>
<%@ include file = "/views/common/footer.jsp"%>