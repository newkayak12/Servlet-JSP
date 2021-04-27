<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <%
    	String name = "김상현";
    	String email = "newkayak12@gmail.com";
    %>
    
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <style>
            ul li {
                color: darkgreen;
                display: inline-block;
            }
            
            li>a {
                text-decoration: none;
                color: magenta;
            }
            
            table {
                width: 300px;
                height: 400px;
                border: 1px black solid;
            }
            
            table td,th {
            	border: 1px solid black;
            }
        </style>


    </head>

    <body>

        <header>
            <ul>
                <li> <a href="content.jsp">메인화면</a></li>
                <li> <a href="board.jsp">게시판</a></li>
                <li> <a href="">갤러리</a></li>
                <li> <a href="">자료실</a></li>
            </ul>

        </header>