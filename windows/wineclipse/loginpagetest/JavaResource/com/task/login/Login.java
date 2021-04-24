package com.task.login;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.logic")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			// form 태그로부터 값 가져오기 
			String userId = (String) request.getParameter("userId");
			String password = (String) request.getParameter("password");
			

			// jdbc 연결
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			//null로 미리 만들어두고 스트림을 닫을 준비를 한다. 
				
					try {

						
						
						
								Class.forName("oracle.jdbc.driver.OracleDriver");	
//							오라클 연결
								conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
//								드라이버 연결
								pstmt = conn.prepareStatement("select * from member where MEMBER_ID=? AND MEMBER_PWD=?" );
//								preparedStatement 쿼리 작성
								pstmt.setString(1, userId);
								pstmt.setString(2, password);
//								getParam 가져와서 검증
								rs = pstmt.executeQuery();
//								쿼리 실행
									if(rs.next()) {
//										rs.next() 리턴이 boolean 있으면 true
										
										System.out.println("success");
										HttpSession session = request.getSession();
											session.setAttribute("userId", userId);
											
											response.sendRedirect("loginsucess.logic");
											
										
										
									} else {
										
										response.sendRedirect("loginfailure.logic");
										
										
									}
								
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						
						try {
//							stream close
							
									if(!rs.isClosed() && rs!=null) {
										rs.close();
									
									if(!pstmt.isClosed() && pstmt!=null) {
										pstmt.close();
									}
									if(!conn.isClosed() && conn !=null) {
										conn.close();
									}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
