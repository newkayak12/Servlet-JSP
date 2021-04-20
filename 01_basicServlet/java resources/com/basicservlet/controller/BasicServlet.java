package com.basicservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 일반 클래스를 스블릿 클래스로 만들기
//서블릿 규약을 준수하면 된다.>> class에 HttpServlet 클래스를 상속받는다.
// javax.servlet.http.HttpServlet 클래스명
//상속을 받은 후 Servlet으로서 역할을 수행하기 위해 두 개의 메소드를 구현한다.
//doGet(), doPost() 메소드를 재정의하여 로직(서비스)를 구현한다.
// 위 메소드를 재정의시에는 규약에 의해서 ServletException 처리를 해줘야한다.


//서블릿 클래스 만들기
//1. 클래스 생성
//2. 클래스에 HttpServlet class를 상속
//3. doGet(), doPost() 메소드 재정의 


public class BasicServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5180306192939093772L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				System.out.println("서버야 요청 들어왔다.");
		
		//HttpservletRequest : 사용자가 보낸 데이터를 저장하는 객체 데이터 관련된 기능을 제공하는 것
		//HttpServletResponse : 사용자에게 응답할 정보를 가지고 있는 객체
		
		
		//HttpServletResponse 객체를 이용해서 응답 메시지 작성하기
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write("<html>");
			out.write("<body>");
			out.write("<h1>내가 만든 서블릿에서 반환한 내용!</h1>");
			out.write("</body>");
			out.write("</html>");
	}
	
	
}
