package com.test.model.service;

import java.sql.Connection;
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
						
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		//		오라클 연결
		//			드라이버 연결
				Member m = dao.login(conn, userId, password);
				try {
					conn.close();
					
				}catch (SQLException e) {
					// TODO: handle exception
				}
		return m;
	}

}
