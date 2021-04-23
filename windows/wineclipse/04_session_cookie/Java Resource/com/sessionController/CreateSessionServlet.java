package com.sessionController;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/sessiontest.do")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
			// session 은 서버에 저장되는 데이터로
		//request객체에서 getSession()으로 생성되고
		// 클라이언트에게는 JSESSIONID로 성성되며,  session 객체의 id값을 전송함
		// 다시 사이트에 접속할 때 cookies에 있는 JSESSIONID값을 가져와 session값을 확인할 수 있다. 
		
		
		
		// Session의 옵션을 살펴보기
			session.setMaxInactiveInterval(10); //second
			session.setAttribute("checktest", "true");
		
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
