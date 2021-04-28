package com.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.test.model.service.TestService;
import com.test.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		클라이언트가 보낸 데이터 가져오기
			String userId = (String) request.getParameter("userId");
			String password = (String) request.getParameter("password");
			
			//DB에 userId, password일치하는 것이 있는지 확인
			TestService service = new TestService();
			Member m = service.login(userId, password);
					
					System.out.println("login servlet");
					System.out.println(userId);
					System.out.println(password);
					
					System.out.println(m.getMemberId());
					System.out.println(m.getMemberPwd());
			
					//db에서 가져온 것을 로그인 처리를 함
					if(m!=null) {
//						 로그인 성공
						System.out.println("login null");
						HttpSession session  = request.getSession();
							session.setAttribute("loginMember",m);
					} else {
						
//						로그인 실패
						
					}
				RequestDispatcher rd = request.getRequestDispatcher("");
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
