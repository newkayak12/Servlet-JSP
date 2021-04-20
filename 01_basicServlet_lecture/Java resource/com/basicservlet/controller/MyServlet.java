package com.basicservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7894108063077974603L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter prw = resp.getWriter();
			
			prw.write("<html>");
			prw.write("<body>");
			prw.write("<h1 style='color: white; background-color: green'>안녕 나는 서블릿이야! 반가워 나 서블릿 잘 만들지</h1>");
			prw.write("</body>");
			prw.write("</html>");
	}

}
