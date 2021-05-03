package com.user.view;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class MainPageView
 */
@WebServlet("/mainpage.do")
public class MainPageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html; charset=utf-8");
			String html = "<html> <head>";
				html += "<style> ul>li { display: inline-block; margin-right :20px; font-size:25px; font-weight:bolder;}</style>";
				html += "</head>";
				html += "<body><h1>bs home page</h1>;";
			HttpSession session = request.getSession(false);
					if(session!=null && session.getAttribute("loginUser")!=null) {
							html+="<ul>";
							html+="<li> main </li>";
							html+="<li> gallery </li>";
							html+="<li> board </li>";
							html+="<li> support </li>";
							html += "</ul>";
							html += "<button onclick='location.assign(\""+request.getContextPath()+"/logout.do\");'>logout</button>";
						
							System.out.println(request.getContextPath()+"/logout.do");
							
					} else {
						html+= "<form action ='/user/login.do' method='post'>";
						html+= "ID : <input type = 'text' name = 'userId'><br>";
						html+= "PW : <input type = 'password' name ='password'><br>";
						html+= "<input type = 'submit' value = 'sign in'>";
						html+= "</form>";
					}
				html += "</body></html>";
				
				response.getWriter().print(html);
				
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
