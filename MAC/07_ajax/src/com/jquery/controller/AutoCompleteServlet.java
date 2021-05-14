package com.jquery.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.admin.model.service.*;
import com.member.model.vo.*;

/**
 * Servlet implementation class AutoCompleteServlet
 */
@WebServlet("/ajax/search.do")
public class AutoCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		List<Member> list = new AdminService().conditionalSearch(keyword, "username", 1, 5);
		String csv = "";
		
		for(int i =0; i<list.size(); i++) {
			if(i!=0) csv+=",";
			csv+=list.get(i).getUserName();
			
		} 
		System.out.println(csv);
		
		response.setContentType("text/csv;charset=utf-8");
		response.getWriter().write(csv);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
