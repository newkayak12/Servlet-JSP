package com.cookieController;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class CookieMaker
 */
@WebServlet("/cookietest.do")
public class CookieOvenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieOvenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키 생성해서 client에 저장시키기
		Cookie c = new Cookie("userId","sanghyun"); //쿠키 객체 생성시 저장할 key:value를 생성자의 매개변수로 넣는다.
		// 서버의 램에 생성된 상태 > 
		// 갓 구운 쿠키는 클라이언트한테 먹으라고 해야한다. 
		// 쿠키를 배달하는 방법은?
			c.setMaxAge(24*60*60); //second 단위임
			response.addCookie(c);
			
		Cookie c2 = new Cookie("email", "newkayak12@gmail.com");
			c2.setMaxAge(60);
			response.addCookie(c2);
			
			
			
		// 응답페이지 작성하기 (로직 다 쓰고 응답 페이지로 넘긴다.
			response.setContentType("text/html; charset=utf-8");
		String html = "<html> <body> ";
			html += "<p> 갓 구운 쿠키를 배달 완료했습니다! </p>";
			html += "<button onclick='location.assign(\"checkcookie.do\")'>쿠키 확인하기</button>";
			html += "</body></html>";
			
			response.getWriter().write(html);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
