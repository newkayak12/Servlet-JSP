package com.basicservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/new.do")
public class Newdo extends HttpServlet{


	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
				System.out.println("annotation.do");
//		
		out.write("<html>");
			out.write("<body>");
				out.write("<pre> 이건 어노테이션으로 만든 겁니다.</pre>");
			out.write("</body>");
		out.write("</html>");
//		
	}
}
