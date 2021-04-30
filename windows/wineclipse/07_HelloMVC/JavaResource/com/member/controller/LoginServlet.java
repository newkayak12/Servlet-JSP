package com.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.service.MemberService;
import com.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
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
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		MemberService lgserv = new MemberService();
		Member m  = lgserv.login(userId, pwd);
			System.out.println("login 로직 실행");
			if( m != null) {
				HttpSession session = request.getSession();
					session.setAttribute("member", m);
					
					//session객체에 대한 설정 및 정보를 가져오는 메소드가 있다.
					//getCreatetime() : 세션 생성 시간 (클라이언트에 세션을 부여한 시간)
					//getlastAcessedTime() : 마지막 접속 시간
					//setMaxinactiveinterval() : 최대 시간

					session.setMaxInactiveInterval(3000);
					
					String saveId = request.getParameter("saveId");
									System.out.println("check : "+saveId);
								
								if(saveId!=null) {
									Cookie saveIdCookie = new Cookie("saveId", userId);
										saveIdCookie.setMaxAge(3600*168);
										response.addCookie(saveIdCookie);
										
								} else {
									
									Cookie c = new Cookie("saveId", "");
										c.setMaxAge(0);
										response.addCookie(c);
									
//									Cookie[] c = request.getCookies();
//									
//										for( Cookie cookie : c) {
//												if(cookie.getName().equals("saveId")) {
//														cookie.setMaxAge(0);
//													Cookie saveIdCookie = cookie;
//														response.addCookie(saveIdCookie);
//												}
//										}
//									
								}
					
					
					response.sendRedirect(request.getContextPath()+"/index.jsp");
					
			} else {
				
				
				//로그인 실패 > 
				// 1. 에러 메시지를 출력해주는 별도의 msg출력 전용 jsp페이지를 구성한다.
				// 2. 에러메시지를 출력하고 나서는 main으로 전환
					request.setAttribute("loc", "/");
				// 3. 로그인 실패에 대한 에러 메시지는 요청에 대한 응답으로 종료되는 데이터 
						request.setAttribute("msg", "login failure, check your id/password");
					RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg.jsp");
						rd.forward(request, response);
						
					
					
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
