package com.servletdats.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendRedirectServlet
 */
@WebServlet("/sendredirect.do")
public class SendRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버에서 전환시키는 두 번째 방법
		//response 객체에 있는 sendRedirect() 를 사용하기
				System.out.println("들어오니?");
			response.sendRedirect("testperson.do");
//		1. url 주소창이 매개변수 값으로 변경된다. 
//			request가 가지고 있던 값은 다 소멸됨 sendRedirect로 새로 서버에 요청하는 것이기 때문에
			
//			데이터를 유지하면서 넘길 때 dispatcher
//			데이터를 날리면서 페이지를 넘길 때 sendRedirect(내가 다시 이전으로 돌아가거나 이전 로직을 다시 수행하지 않아야할 때)
//			__ logout로직, 회원가입, 게시판 등록했을 때 _ 이걸 안쓰면 무한대로 이전의 로직을 수행시켜버릴 수도 있어서...
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
