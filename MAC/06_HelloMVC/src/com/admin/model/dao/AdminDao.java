package com.admin.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.common.*;
import com.member.model.vo.*;

public class AdminDao {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = new Properties();
	
	
	public AdminDao() {
	
		try {
			String filePath=AdminDao.class.getResource("/sql/admin_sql.properties").getPath();
			prop.load(new FileReader(filePath));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
			
	
	
	public List<Member> showAllMember(Connection conn, int cPage, int numPerPage) {
		List<Member> result = new ArrayList();
		Member m = null;
			try {
				pstmt = conn.prepareStatement(prop.getProperty("admin_showAll"));
//				cPage : 1 numPerPage 5 > 시작 1 끝 5 
//				cPage : 2 numPerPage 5 >  시작 6 끝 10
//				cPage : 3 numPerPage 5 >  시작 11 끝 15
//				
//				계차수열이네?
//				(cPage-1)*numPerPage+1 > 시작 
//				(cPage*numberPerPage) > 끝
				
				
				
				pstmt.setInt(1, (cPage-1)*numPerPage +1);
				pstmt.setInt(2, (cPage*numPerPage));
				
				
				rs = pstmt.executeQuery();
				
					while(rs.next()){
						
						//조회된 row가 있다
						m=new Member();
						m.setUserId(rs.getString("userid"));
						m.setPassword(rs.getString("password"));
						m.setUserName(rs.getString("username"));
						m.setAge(rs.getInt("age"));
						//char형으로 데이터를 받을 때 사용
						//m.setGender(rs.getString("gender").charAt(0));
						m.setGender(rs.getString("gender"));
						
						String email = null;
							try {
								
								
								email = AESCryptor.decrypt(rs.getString("email"));
								
								
							} catch (Exception e) {
								
								email  = rs.getString("email");
							}
						
						
						m.setEmail(email);
						
						String phone = null;
							try {
								
								
								phone = AESCryptor.decrypt(rs.getString("phone"));
								
								
							} catch (Exception e) {
								
								phone  = rs.getString("phone");
							}
							
						
						m.setPhone(phone);
						
						m.setAddress(rs.getString("address"));
						m.setHobby(rs.getString("hobby"));
						m.setEnrollDate(rs.getDate("enrolldate"));
						
						result.add(m);
						
						
					}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		
		
		return result;
	}




	public int countMember(Connection conn) {
		
		List<Member> result = new ArrayList();
		Member m = null;
		int num  = 0;
			try {
				pstmt = conn.prepareStatement(prop.getProperty("admin_count"));
				rs = pstmt.executeQuery();
					
					if(rs.next()) {
						num = rs.getInt(1);
	//					이렇게 계산식이 있는 것은 그냥 인덱스로 가져오는게 나을 수도 있다.
					}
					
		
		
				} catch (SQLException e) {
					// TODO: handle exception
				}
			return num;


	}
}