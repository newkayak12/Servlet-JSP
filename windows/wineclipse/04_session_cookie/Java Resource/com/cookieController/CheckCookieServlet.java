package com.cookieController;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class CheckCookieServlet
 */
@WebServlet("/checkcookie.do")
	public class CheckCookieServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public CheckCookieServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	클라이언트가 보낸 쿠키를 확인하기
//		쿠키 값은 request객체의 getCookies() 메소드를 이용해서 가져온다.
//		getCookies()의 반환형은 Cookie[]이다. 
//		서버에서 저장시키는 쿠키 값이 한 개가 아니기 때문이다.
			
			Cookie[] cookies = request.getCookies(); 
				response.setContentType("text/html; charset=utf-8");
				
			String html = "<html><body> <h1> 갓 구운 쿠키가 배달왔습니다!</h1>";
				if(cookies != null) { //저장된 쿠키가 없으면 null을 반환
							for(Cookie c : cookies) {
								//Cookie값을 확인하려면 메소드를 이용해야한다. getName(), getValue()
												System.out.println(c.getName() + " : " +  c.getValue());
								html +="<p>" + c.getName() + " : " + c.getValue() + "</p>";
												
							}
						html += "<h2><a href = 'deletecookie.do'>쿠키 삭제</a></h2>";
						html += "<h2><a href = '"+request.getContextPath()+"'>home</a></h2>";
						html += "</body></html>";
					
					response.getWriter().write(html);
				}
		
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
	}
