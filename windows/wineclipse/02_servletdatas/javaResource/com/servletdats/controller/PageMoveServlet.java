package com.servletdats.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPersonServlet2
 */
@WebServlet("/pagemove.do")
public class PageMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageMoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//특정 데이터를 request 객체에 보관을 하고 >> request 객체는 데이터를 보관할 수 있다. 
//		응답 기능을 하는 서블릿을 호출하여(요청) 응답처리하는 로직 구현
//		이는 서버 내에서 다른 서블릿의 메소드를 실행 시키는 방법을 의미한다.
		
//		1. request 객체에 원하는 데이터 넣기
//		setAttribute("key", "object(value)"; -> request 객체에 특정 데이터가 저장이 된다.
		request.setAttribute("msg", "점심 맛있게 먹었나요??");
		request.setAttribute("tody", new Date());
//		만약 key값이 동일하게 저장이 된다면? 
		request.setAttribute("msg", "이젠 request 데이터를 넣을 수 있어요");
//		덮어써버린다... 키값을 중복하게 저장할 수 없다. (자료구조가 MAP형식이기 때문이다.)
		
		
//		2. 데이터를 넣고 request 객체에 저장된 데이터 가져오기 
		//getAttribute("key"); -> request객체에 저장된 값을 가져오는 기능
		
		String msg =  (String) request.getAttribute("msg");
		Date today = (Date)request.getAttribute("tody");
					System.out.println(msg);
					System.out.println(today);
		 
//		3. 다른 서블릿으로 넘겨서 전환을 해보자
		// 다른 서블릿을 호출해보자 > getRequestDispatcher()라는 메소드를 이용해서 처리한다.
//		requestDispatcher라는 객체가 생성이 되고 이 객체의 forward()메소드를 이용하면 
//		지정된 서블릿이 호출된다. 
//		getRequestDispatcher("서블릿 매핑주소" || jsp주소);
//		RequestDispathcer.forward(request,response); (데이터, 응답할 주소)
		RequestDispatcher rd = request.getRequestDispatcher("testperson.do");
			rd.forward(request, response); // 이 때 서블릿을 호출해서 실행한다. 
//		최초 client가 요청한 주소에서 바뀌지 않는다. pagemove에서 서블릿을 호출해서 주소는 pagemove고 내용은 testPerson것을 가져온다.
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
