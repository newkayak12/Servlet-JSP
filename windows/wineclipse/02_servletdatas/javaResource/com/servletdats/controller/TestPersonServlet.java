package com.servletdats.controller;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class TestPersonServlet
 */
@WebServlet("/testperson.do")
public class TestPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		데이터에 한글이 있는 경우
//		1. request/ response에 encoding 설정을 해줌
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		
//		2. 클라이언트가 보낸 파라미터 값 받아오기
//			1. 기본 데이터 받아오기
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
			//이 친구들은 단일 값을 받아 올 때 사용한다.
		double height = Double.parseDouble(request.getParameter("height"));
//			기본적으로 String이기 때문에 Parsing처리하면 됨
		
		String color = request.getParameter("color");
		
//		String foods = request.getParameter("foods");
//			이 친구 같은 경우는 다중값이라 생각해야할 게 있음 위와 같이는 할 수 없음
//		전송되는 데이터가 다중 값일 때는 
		String[] foods = request.getParameterValues("foods");
		
		
		String animal = request.getParameter("animal");
					System.out.println("그냥 출력");
					
					System.out.println("이름 " + name);
					System.out.println("나이 " + age);
					System.out.println("키 " + height);
					System.out.println("색상 " +  color);
				
//				for(String temp : foods) {
//							System.out.println(temp);
//				}
					System.out.println("음식 " + Arrays.asList(foods));
					System.out.println("동물 " + animal);
				
		
//		name을 모르면?? key를 뭘로 가져와야하나...
//		key 값 전체를 가져올 수 있는 메소드
//		getParameterNames > 클라이언트가 보낸 데이터의 key를 모두 보여주는 메소드
					System.out.println("\n\n=== 모든 key를 출력 ===");
					
		Enumeration<String> keys = request.getParameterNames();
		ArrayList<String[]> sendData = new ArrayList();
				
				
				while(keys.hasMoreElements()) {
					String key = keys.nextElement();
						sendData.add(request.getParameterValues(key));
				}
					System.out.println("\nsendData출력");
					System.out.println(sendData);
					
					System.out.println("\n이중 for");
				for(String[] v : sendData) {
					for(String vs : v) {
						System.out.println(vs);
					}
				}
//		context auto load가 되는 조건
//		새로 만들어진 servlet을 만들어서 코드를 추가하는 경우 context에 추가가 안되있어서 auto load가 안됨
		
				
				
				
//		값을 전체 key, value 값을 한 번에 받을 수 있는 기능
//		getParameterMap : Map을 이용해서 모든 클라이언트가 전송한 key, value를 받는다.
		Map<String, String[]> mapData  = request.getParameterMap();
					System.out.println("\n\nmap으로 받기");
					System.out.println(mapData);
		Set<Map.Entry<String, String[]>> entry = mapData.entrySet();
		Iterator<Map.Entry<String, String[]>> it = entry.iterator();
				while(it.hasNext()) {
					Map.Entry<String, String[]> p = it.next();
								System.out.println("key : "+p.getKey());
								
							for(String s : p.getValue()) {
								System.out.print("value : " + s+" ");
							}
							System.out.println("\n");
				}
				
//////////////////////////////////////////// PageMoveServlet에서 Attribute 설정한 녀석을 가져오면 어떻게 될까??????????????????????????????????????????????
//				request 객체에 setAttribute로 넣은 값을 가져오기
		String msg = (String)request.getAttribute("msg");
		Date today = (Date)request.getAttribute("tody");
//		만약 attribute 값을 가져올 때  key와 연결되어있는 데이터가 없다면 null을 반환 == 에러 발생이 없다.
				System.out.println("attribute : "+msg);
				System.out.println("attribute : "+today);
				
//				없는데도 불구하고 exception 없이 null을 순순히 반환함 
//////////////////////////////////////////////////////////////////////////////
				
				
		//기본 응답 페이지 작성하기
//		응답을 위해서는 HttpServletResponse를 이용한다.
//		응답하기 위한 클라이언트의 정보를 가지고 있음
				
// 		1. 응답하는 방식을 결정 : response 객체에 response.setContentType();를 이용한다.
//			전송되는 데이터 형식(MIMEType), 인코딩 방식을 설정
			response.setContentType("text/html;charset=utf-8");
//			클라이언트와 연결되는 문자열 Stream을 가져오는 메소드
			// getWriter()
			PrintWriter prtw = response.getWriter();
			String html ="<html>";
				
				html += "<body> <h1>";
					if(msg!=null) {
						
						html += msg+ "</h1>";
					}
					
					if(today!=null) {
						html+="<h3>" + new SimpleDateFormat("yy-mm-dd").format(today) +"</h3>";
					}
				html += "<h1>당신의 취향 테스트 결과? </h1>";
				html += "<h2> 당신의 이름은 " +name +"<h2>\n";
				html += "<h2> 당신의 나이는 " +age+ "<h2>\n";
				html += "<h2> 당신의 키는" +height+ "<h2>\n";
				html += "<p> 당신이 좋아하는 색은 ";
				html += " <span style='background-color:"+color+";'></span>";
						
				html += "<P> 당신이 좋아하는 음식은 </p> <ul>";
				
					for(String f : foods) {
						String src ="";
								switch (f) {
									case "콩불":
										src = "https://recipe1.ezmember.co.kr/cache/recipe/2019/11/05/21dd38ded6a265dec5fbc9bff24fca1e1.jpg";
										break;
	
									case "카레" :
										src = "https://static.wtable.co.kr/image-resize/production/service/recipe/260/4x3/8e1380e6-d21e-46c7-8b56-b26e6c836bb1.jpg";
										break;
										
									case "마라탕" :
										src = "data:image/jpeg;base64,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";
										break;
										
									default :
										src = "https://folo.co.kr/img/gm_noimage.png";
										break;
								}
							html+= "<li><img src = \'"+src+"\' width = '100 px' height ='100px'>"+f+"</li>";
						}

					
				html += "</ul>";
				html += "<p>당신이 좋아하는 동물은 " +animal+"</p>";
				html += "</body></html>";
				
				prtw.write(html);

				
				
		
				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
