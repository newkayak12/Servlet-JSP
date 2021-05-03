package com.listenerController;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class SessionListenerTestServlet
 */
@WebServlet("/sessiontest.do")
	public class SessionListenerTestServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public SessionListenerTestServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
//				이 때 세션 리스너가 실행된다. 쿠키에 sessionid가 부여되면 실행 X _ 쿠기는 서버 내렸다 올려도 사용자의 브라우저에 귀속되기 때문에... 상관이 없음
//				JSP로 index를 구현하면 자동으로 session이 생성된다. 그래서 attribute로... 
//				attribute는 세션에 session.setAttribute("Key","value);로 하면 
			
				session.setAttribute("id", "id");
				session.invalidate();
		
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
	}
