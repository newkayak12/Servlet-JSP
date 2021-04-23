package com.sessionController;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class CheckSessionServlet
 */
@WebServlet("/checksession.do")
	public class CheckSessionServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public CheckSessionServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//세션 에 있는 값 확인하기
			//session을 가져올 때 getSession()을 이용하는데, ()에 true, false를 넣을 수 있다.
			//true : 세션이 있으면 그 세션 가져오고 없으면 생성 *default
			//false :  세션이 있으면 그 세션을 가져오고 없으면 null을 반환 
			
			HttpSession session = request.getSession(false);
							System.out.println(session);
							
							
						if( session !=null) {
										System.out.println((String) session.getAttribute("checktest"));
						} else {
										System.out.println("session이 없습니다.");
						}
						
						
				response.sendRedirect(request.getContextPath());
			
			
		
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
	}
