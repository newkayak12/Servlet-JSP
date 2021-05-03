package com.servletdats.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class SharedData
 */
@WebServlet("/share.do")
	public class SharedData22 extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public SharedData22() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			데이터를 저장할 수 있는 객체 가져오기
//			1. ServletContext 객체 불러오기 > 서버 전역에서 이용할 수 있는 데이터를 저장할 수 있는 객체
//			ServletContext context = request.getServletContext();
//			저장 내용 유효기간 서버 runtime~shutdown 까지
			ServletContext context = getServletContext();
			context.setAttribute("context", "contextData");
			
//			2. HttpSession 객체 불러오기 > 개발자가 지정한 기간 동안 사용자 별로 데이터를 저장할 수 있는 객체
//			저장 내용 유효 기간은 session 생성 순간부터 session 소멸 순간까지 
			HttpSession session = request.getSession(); // 세선이 생성되면 클라이언트에 session id 값이 부여된다. 그럼 그 id값을 기준으로 사용자에 저장소를 부여
			session.setAttribute("session", "sessionData");
			
//			3. HttpServletRequest 객체 > 클라이언트가 Request를 보내면 생성되는 객체
//			요청(request)에 대해서 한 번이라도 응답(response)를 하면 종료가 된다. 
			request.setAttribute("request", "requestData");
			
//			궁금한건 이 녀석들이 언제 생성되고 어디까지 유지가 되느냐이다. 
			
			//Requestdispatcher로 전달하기
			
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("usedata.do");
			 * rd.forward(request,response); //다른 서블릿으로 전환한다.
			 */	
			
			/*
			 * requestData :requestData 
			 * contextData :contextData 
			 * sessionData :sessionData
			 * 
			 * REQUEST만 나가리됐음
			 */
			
			
			
			//sendRedirect로 이동하면???
			response.sendRedirect("usedata.do");
			// 얘로 보내면 request는 사라지네
		
			/*
			 * requestData :null 
			 * contextData :contextData 
			 * sessionData :sessionData
			 * 
			 * REQUEST만 나가리됐음
			 */
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
	}
