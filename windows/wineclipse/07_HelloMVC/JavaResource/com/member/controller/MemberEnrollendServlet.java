package com.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.service.MemberService;

/**
 * Servlet implementation class MemberEnrollendServlet
 */
@WebServlet("/memberenrollend.do")
public class MemberEnrollendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	MemberService mServ = new MemberService();
     
	/* @see HttpServlet#HttpServlet()
     */
    public MemberEnrollendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = (String)request.getParameter("userId");
		String password = (String)request.getParameter("password");
		String userName = (String) request.getParameter("userName");
		int age = Integer.parseInt( request.getParameter("age") );
		String email = (String) request.getParameter("email");
		String phone = (String) request.getParameter("phone");
		String address = (String) request.getParameter("address");
		char gender = (request.getParameter("gender")).charAt(0);
		String hobby = null;
		
		
		String[] hobbyArray = (String[]) request.getParameterValues("hobby");
			for(String temp : hobbyArray) {
				
				hobby += temp+",";
			}
			
		int result = mServ.enroll(userId, password, userName, age, email, phone, address, gender, hobby);
		
				if(result > 1) {
					request.setAttribute("msg", "가입 완료!");
					response.sendRedirect("/views/common/msg.jsp");
					System.out.println(request.getContextPath());
				}  else {
					System.out.println(request.getContextPath());
					request.setAttribute("msg", "가입 실패!");
					response.sendRedirect("/views/common/msg.jsp");
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
