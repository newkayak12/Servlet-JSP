package com.jquery.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;

import com.admin.model.service.*;
import com.google.gson.*;
import com.member.model.vo.*;


/**
 * Servlet implementation class JsonListDataServlet
 */
@WebServlet("/json/listData")
public class JsonListDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonListDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyword = request.getParameter("keyword");
		List<Member> list =new AdminService().conditionalSearch(keyword, "username", 1, 10);
		//list 로 받아온 데이터를 json으로 전환하여 넘기려면 jsonArray클래스를 이용한다.
//		JSONArray jarray = new JSONArray();
//			for(Member m : list) {
//				JSONObject jo = new JSONObject();
//				jo.put("userid", m.getUserId());
//				jo.put("username", m.getUserName());
//				jo.put("age", m.getAge());
//				jo.put("email",m.getEmail());
//				//jsonsimple은 기본 자료형에 대해서만 파싱함 Object는 파싱하지 않음 
//				
//				jarray.add(jo);
//				
//				
//			}
		
			
			response.setContentType("application/json;charset=utf-8");
//			response.getWriter().print(jarray);
			new Gson().toJson(list,response.getWriter());
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
