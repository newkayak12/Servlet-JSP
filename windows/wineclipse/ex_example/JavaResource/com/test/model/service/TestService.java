package com.test.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.model.dao.TestDao;
import com.test.model.vo.Member;

public class TestService {
	private TestDao dao = new TestDao();
	

	public Member login(String userId, String password) {
		Connection conn = null;
		
				
				
				try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		//		오라클 연결
		//			드라이버 연결
				Member m = dao.login(conn, userId, password);
				
		return m;
	}

}
