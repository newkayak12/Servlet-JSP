package com.jquery.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.jquery.model.vo.*;

/**
 * Servlet implementation class CsvTestServlet
 */
@WebServlet("/ajax/csvTest.do")
public class CsvTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsvTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ajax요청에 csv방식으로 데이터를 응답해주기 
		List<Member> list = new ArrayList();
		list.add(new Member("박보검","01045631234","parkBogum.jpg"));
		list.add(new Member("쥴리아 로버츠","01012345678","juliaRoberts.jpg"));
		list.add(new Member("맷 데이먼","01012349238","mattDamon.jpg"));
		
		String csv = "";
		
		for(int i =0; i<list.size(); i++) {
			if(i!=0) csv +="\n";
			csv += list.get(i);
		}
		
		System.out.println(csv);
		
		response.setContentType("text/csv; charset=utf-8");
		response.getWriter().print(csv);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
