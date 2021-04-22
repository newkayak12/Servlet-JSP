package com.servletdats.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class PrintMain22
 */
@WebServlet("/printmain.do")
	public class PrintMain22 extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public PrintMain22() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			
			String id  = (String) session.getAttribute("id");
			String pw  = (String) session.getAttribute("pw");
				
				response.setContentType("text/html; charset=utf-8");
			PrintWriter prw = response.getWriter();
			
			String html = "<html> <body>";
			
					if((id.equals("admin")) && (pw.equals("1234"))) {
						
						html += "<h1> ID : " + id + "</h1>";
						html += "<h1> PW : " + pw.substring(0,2)+"**** </h1>";
						html += "<button onclick = 'location.replace(\""+request.getContextPath()+"/sessiondelete.do\");'> 로그아웃 </button>";
						
					} else {
						
						html += "<p style='color : red; font-size:64px';>invalid! </p>";
						html += "<button onclick = 'location.replace(\""+request.getContextPath()+"/sessiondelete.do\");'> 로그아웃 </button>";
					}
			
				
				html += "</body> </html>";
				
				prw.write(html);
			
		
		
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
	}
