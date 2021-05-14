package com.jquery.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;

import com.jquery.model.vo.*;

/**
 * Servlet implementation class JsonBasicServlet
 */
@WebServlet("/json/basicData")
public class JsonBasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonBasicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	Json 방식으로 응답하기 위해서는 라이브러리를 사용하면 됨.
// json-simpe을 이용해서 json으로 응답하기
//	단일 객체와 다수 객체(list)를 JSON방식으로 보낼 수 있게 클래스가 구성되어있다.
		
//		단일 객체 > JSONObject클래스 
//		다수 객체 > JSONArray클래스를 이용한다.  >> JSONOBJECT를 JSONARRAY안에 담는 거임....
		
		Member m1 = new Member("박보검","01022029302","parkBogum.jpg");
		Member m2 = new Member("쥴리아 로버츠","01012345678","juliaRoberts.jpg");
		Member m3 = new Member("맷 데이먼","01012349238","mattDamon.jpg");
		
		JSONObject json = new JSONObject();
		json.put("name", m1.getName());
		json.put("phone", m1.getPhone());
		json.put("profile", m1.getProfile());
		json.put("age",new Integer(29));
		json.put("height", new Double(185.5));
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(json);
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
