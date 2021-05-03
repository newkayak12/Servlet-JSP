package com.user.controller;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/user/login")
	public class UserLoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public UserLoginServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//1. clinet가 보낸 데이터 받아오기
			String userId = (String) request.getParameter("userId");
			String password = (String) request.getParameter("password");
		
		//2. service logic을 구현 > Client's id,pw를 db에 저장되어 있는지 확인하고
		//저장되어있으면 로그인 성공/ 아니면 실패! 하는 로직
		//<CONTROLLER>  Servlet은 > <MODEL> Service > Dao 순으로 요청
			
			
			//1. 드라이버 올리기
			//2. connection정보 가져오기
			//3. connection 객체에서 prestatement
			//4. resultset
			Connection con = null;
			PreparedStatement pstmt =null;
			ResultSet rs  =null;
			boolean result = false;
					try {
							Class.forName("oracle.jdbc.driver.OracleDriver");
							 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
							
							pstmt =  con.prepareStatement("select * from member where MEMBER_ID=? AND MEMBER_PWD=?");
							pstmt.setString(1, userId);
							pstmt.setString(2, password);
							rs = pstmt.executeQuery();
								if(rs.next()) {
									result= true;
									
								}
							System.out.println(result);
						
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					
		String path = "";	
					if( result ) {
						//로그인이 성공
						//로그인 성공하면 그 값을 유지하기 위해서 session객체에 데이터를 대입
						
						HttpSession session = request.getSession();
							session.setAttribute("loginUser", userId);  //vo객체
							path="/mainpage.do";
							
					} else {
						
						//fail
						
						request.setAttribute("msg", "sign in failure");
						path="/msg.do";
					}
		RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			
			
			
			
		
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}
