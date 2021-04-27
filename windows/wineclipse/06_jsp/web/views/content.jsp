<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file = "/views/common/header.jsp" %>
        <section>
            <h1>내용이 나오는 부분</h1>
            <h2> <%= email + name %></h2>
            
            
            <p> WELCOME TO JSP</p>
            <table>
                <tr>
                    <th>이름</th>
                    <th>나이</th>
                    <th>성별</th>
                    <th>키</th>

                </tr>

                <tr>
                    <td>유병승</td>
                    <td>19</td>
                    <td>남</td>
                    <td>180</td>

                </tr>
                <tr>
                    <td>김상현</td>
                    <td>29</td>
                    <td>남</td>
                    <td>180</td>

                </tr>
            </table>




        </section>
        <%@ include file = "/views/common/footer.jsp" %>