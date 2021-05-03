package com.servletdats.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class SessionDel
 */
@WebServlet("/sessiondelete.do")
	public class SessionDel22 extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public SessionDel22() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//session객체는 개발자가 로직에 의해서 삭제하지 않는 한 유지된다. 
			// 따라서 여기서 삭제하는 것을 할 것\
//			session 객체를 삭제하는 방법 : session.invalidate() 메소드 호출
			
			HttpSession session = request.getSession();
				session.invalidate();
			
			RequestDispatcher rd  = request.getRequestDispatcher("/usedata.do");
				rd.forward(request, response);
		
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
	}
