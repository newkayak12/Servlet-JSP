package com.servletdats.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class LoginCheckServlet22
 */
@WebServlet("/logincheck.do")
public class LoginCheckServlet22 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet22() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//사용자가 보낸 데이터를 입력받고 가져오기 
//		가져온 데이터를 session에 저장하기
		 String id =  request.getParameter("userId");
		 String pw =  request.getParameter("password");
		 
		 System.out.println(id +" "+ pw);
		 
		 	
		 			HttpSession session = request.getSession();
		 				session.setAttribute("id", id);
		 				session.setAttribute("pw", pw);
		 				
	 				RequestDispatcher rd = request.getRequestDispatcher("printmain.do");
	 					rd.forward(request, response);
		 			
	}	
		 		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
