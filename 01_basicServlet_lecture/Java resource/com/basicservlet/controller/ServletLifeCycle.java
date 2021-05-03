package com.basicservlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLifeCycle
 */
@WebServlet("/lifeCycle.do")
public class ServletLifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ServletLifeCycle() {
		// TODO Auto-generated constructor stub
		System.out.println("서블릿 기본 생성자 호출");
	}
	
	@Override
		public void init() throws ServletException {
					System.out.println("init() 메소드 호출");
			
		}
	
	@Override
		public void destroy() {
					System.out.println("destroy() 메소드 호출 객체 삭제");
		}
	
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					System.out.println("service() 메소드 호출");
				super.service(req, resp);
		}
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					System.out.println("doGet() 메소드 호출");
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					System.out.println("doPost() 메소드 호출");
	}	
}
