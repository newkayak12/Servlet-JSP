package com.common;

import java.io.*;
import java.sql.*;
import java.util.*;

public class JDBCTemplate {

	public JDBCTemplate() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			
			String path = JDBCTemplate.class.getResource("/driver.properties").getPath();
				prop.load(new FileInputStream(path));
			Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("id"), prop.getProperty("pw"));
				conn.setAutoCommit(false);
			
		}catch( ClassNotFoundException |IOException | SQLException e) {
			
		}
		
		return conn;
	}
	
	
	
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				
				conn.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  void close(PreparedStatement pstmt) {
		try {
			if(pstmt!=null && !pstmt.isClosed()) {
				
				pstmt.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed()) {
				
				rs.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
