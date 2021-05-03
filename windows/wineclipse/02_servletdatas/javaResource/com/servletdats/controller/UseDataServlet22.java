package com.servletdats.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class UseDataServlet
 */
@WebServlet("/usedata.do")
public class UseDataServlet22 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UseDataServlet22() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 데이터 저장 객체에 저장되어 있는 데이터 호출하기
		ServletContext context = request.getServletContext();
		HttpSession session = request.getSession();
		
		String requestData = (String) request.getAttribute("request");
		String contextData = (String) context.getAttribute("context");
		String sessionData = (String) session.getAttribute("session");
		
			response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String html = "<html>";
			html += "<body>";
			html += "<ul>";
			html += "<li> requestData :" + requestData +"</li>";
			html += "<li> contextData :" + contextData +"</li>";
			html += "<li> sessionData :" + sessionData +"</li>";
			html += "</ul>";
//			html += "<button onclick = 'locataion.assign(\"02_servletdatas/sessiondel.do\")'>session삭제</button>";
			
			
			html += "<button onclick='location.assign(\"/02_servletdatas/sessiondelete.do\")'>세션 삭제</button> ";
			html += " </body>";
			html += "</html>";
			
			
			
			out.print(html);
			
			// 첫 응답까지는 request/ context/ session 모두 살아 있다.  그러면 다시 한 번 응답한다면 어떨까?
			
//		contextdata지워지는 순간 다시 보기 10:48분 			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
