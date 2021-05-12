<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.board.model.vo.Board" %>

<%@ include file="/views/common/header.jsp" %>
<style>
    section#board-container{width:600px; margin:0 auto; text-align:center;}
    section#board-container h2{margin:10px 0;}
    table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>
   
		<div id="board-container">
		<h2>게시판</h2>
		<%Board board =(Board) request.getAttribute("result");
		
		System.out.println("BoardDetail.jsp come");%>
		<form>
		<table id="tbl-board">
			<tr>
				<th>글번호</th>
				<td><%=board.getBoardNo() %></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><%=board.getBoardTitle() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=board.getBoardWriter()%></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=board.getBoardReadCount()%></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				
			<%if(board.getBoardOriginalFileName()!=null){ %>	
				<td>
					 <a href =""> 
					 <img alt="" src="<%=request.getContextPath()%>/images/file.png" width="16px" height="16px">
					 
					 </a>
				</td>
			<%} else { %>	
				<td>
				 <span>NO_FILE</span>
				</td>
			<%} %>	
			</tr>
			<tr>
				<th>내 용</th>
				<td><%=board.getBoardContent() %></td>
			</tr>
			<%--글작성자/관리자인경우 수정삭제 가능 --%>
			
			<tr>
				<th colspan="2">
					<button type="button" onlclick="location.assign('<%=request.getContextPath()%>/board/boardlist')">목록으로</button>
					<input type="button" value="수정하기" onclick="">
					<input type="button" value="삭제하기" onclick="">
				</th>
			</tr>
			
			
		</table>
   	</form>
    </div>

<%@ include file="/views/common/footer.jsp" %>