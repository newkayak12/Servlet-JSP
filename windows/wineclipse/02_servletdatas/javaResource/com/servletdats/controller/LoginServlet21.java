package com.servletdats.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
	public class LoginServlet21 extends HttpServlet{
	
		/**
		 * 
		 */
			private static final long serialVersionUID = 1638844313373237746L;
		
		@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
						System.out.println("get방식으로 처리하기");
							
							//클라이언트가 보낸 데이터 확인 
//							클라이언트가 front에서 보낸 데이터는 parameter라고 지칭한다.
//							클라이언트가 보낸 데이터는 HttpServletRequest 객체에 저장이 되어있다.
//							getParameter("key || input 태그의 name 속성에 있는 값")으로 가져온다.
						
						
						req.setCharacterEncoding("utf-8"); // 얘는 인코딩을 바꿔줘야하니까 보통 최상단에 작성
						
						
						
				String id = req.getParameter("userId");
				String pw = req.getParameter("pw");
				
						System.out.println(id+" "+pw);
//							가져온 데이터는 String이다.
						
					resp.setContentType("text/html; charset=utf-8");
				String html ="<html>";
					html += "<body>";
					html += "<h1>"+"당신이 입력한 아이디는 "+ id + " 비밀번호는 " + pw.substring(0,2)+"****"+"</h1>";
					html += "</body>";
					html += "</html>";
				PrintWriter out = resp.getWriter();
					out.write(html);
					
//				get 방식은 주소창 선에서 인코딩해서 넘겨서 인코딩을 따로 해주지 않아도 문제가 없는데
							
			}
			
		@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
							System.out.println("post방식으로 처리하기");
						doGet(req,resp);
//						굳이 post/get이든 보내면 장떙 로직 구성은 그냥 다 get에서 하면 되니까
						
						
//						얘는 http 헤더에서 뽑아내니까 따로 인코딩을 잡아줘야하는 문제가 있다.
//						post 방식으로 영어/숫자를 제외한 데이터는 깨지는 일이 발생한다.
//						setCharacterEncoding("utf-8")메소드를 이용함
			}
		
//		get으로 오던 post로 오던 내부로 들어오기만 하면 장떙이니까
	
	}
