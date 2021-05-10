<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "com.task_emp.model.vo.Employee" %>
<%@ page import = "java.util.*" %>
    <%@ include file ="/views/common/header.jsp" %>
    
    
    
    <main>
    
        <div>
        
            <table>
                <tr>
                    <th>사번</th>
                    <th>이름</th>
                    <th>주민등록번호</th>
                    <th>이메일</th>
                    <th>전화번호</th>
                    <th>부서코드</th>
                    <th>직업코드</th>
                    <th>급여코드</th>
                    <th>월급</th>
                    <th>보너스</th>
                    <th>사수 사번</th>
                    <th>입사일</th>
                    <th>퇴사일</th>
                    <th>퇴사여부</th>
                </tr>
                <%List<Employee> result = (List<Employee>) request.getAttribute("result"); %>
	            <%if( result != null && result.size()>0) { 
	            
	            	for(Employee emp : result){
	            %>    
	                <tr>
	                    <td><%= %></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
                <%}
                } else { %>
                
                	<tr>
                	 	<td colspan ="14"> 결과 값이 없습니다. </td>
                	</tr>
                
                <%} %>
                
            </table>
        
        </div>
        
    
    </main>
    
    <%@ include file = "/views/common/footer.jsp"%>