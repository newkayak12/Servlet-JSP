<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.test.model.vo.Member" %>
<%
	
		
	Member loginMem = (Member) session.getAttribute("loginMember");
	
%>
    <!DOCTYPE html>
    

    <html>

    <head>
        <meta charset="UTF-8">
        <title>PAGE</title>
        <style>
            ul>li{
                display: inline-block;
                margin-right: 30px;
                font-size: 30px;
                font-weight: bolder;
            }

            ul>li>a{
                text-decoration: none;
                color: darkgreen;

            }

            header{
                display: flex;
            }
            header{
                display: flex;
                justify-content: space-between;
                border: 1px black solid;
            }
            
        </style>
    </head>

    <body>
        <header>
            <div></div>
            <div>

                <ul>
                    <li>
                        <a href="">메인</a>
                    </li>
                    <li>
                        <a href="">게시판</a>
                    </li>
                    <li>
                        <a href="">갤러리</a>
                    </li>
                    <li>
                        <a href="">자료실</a>
                    </li>
                </ul>

            </div>
            <div>
            <% if(loginMem == null) { %>
                 <form action="login.post" method="POST">
	                <table>
	                    <tr>
	                        <td>ID</td>
	                        <td><input type="text" name="userId" id="userId"></td>
	                    </tr>
	                    <tr>
	                        <td>PASSWORD</td>
	                        <td><input type="password" name="password" id="password"></td>
	                    </tr>
	                    <tr>
	                        <td> <input type="submit" value="Sign In" ></td>
	                        <td> <input type="reset" value="cancel"></td>
	                    </tr>
	                </table>
            
           		 </form>
                 <% } else{	 %>
                 	<h3> <%=loginMem.getMemberId() %>님 환영합니다.</h3>
                 <%
                 	System.out.println(loginMem.getMemberId());
                 } %>
            </div>

        </header>