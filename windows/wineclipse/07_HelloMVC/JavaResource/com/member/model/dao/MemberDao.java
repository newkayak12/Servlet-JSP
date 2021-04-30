package com.member.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import com.member.model.vo.Member;

public class MemberDao {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Member m = null;
	private Properties prop = new Properties();
	private String sql = "";
	String path = "";
	
	
	public Member login(String userId, String pwd, Connection connection) {
		
				try {
					
						path = MemberDao.class.getResource("").getPath();
//						String path = "C:\\Users\\newka\\OneDrive - 충남대학교\\dev\\Servlet-JSP\\windows\\wineclipse\\07_HelloMVC\\JavaResource\\resource\\sql\\sql.properties";
							prop.load(new FileReader(path));
							sql = prop.getProperty("select");
							
//							sql.replace("@", userId);
//							sql.replace("#", pwd);
							pstmt = connection.prepareStatement(sql);
							pstmt.setString(1, userId);
							pstmt.setString(2, pwd);
							rs = pstmt.executeQuery();
							
								if(rs.next()) {
										m = new Member();
										m.setUserId(rs.getString("USERID"));
										m.setPassword(rs.getString("PASSWORD"));
										m.setUserName(rs.getString("USERNAME"));
										m.setGender(rs.getString("GENDER").charAt(0));
										m.setAge(Integer.parseInt(rs.getString("AGE")));
										m.setEmail(rs.getString("EMAIL"));
										m.setPhone(rs.getString("Phone"));
										m.setAddress(rs.getString("ADDRESS"));
										m.setHobby(rs.getString("HOBBY"));
								}
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					close(rs);
					close(pstmt);
					
				}
				
				
				
				return m;
	}


	public int enroll(Connection conn, String userId, String password, String userName, int age, String email,
			String phone, String address, char gender, String hobby) {
		
		path = MemberDao.class.getResource("/").getPath();
			System.out.println(path);
			path = MemberDao.class.getResource("/resource").getPath();
			System.out.println(path);
			path = MemberDao.class.getResource("/resource/sql/sql.properties").getPath();
			System.out.println(path);
		
			int result = 0;
				try {
					prop.load(new FileInputStream(path));
					sql = prop.getProperty("insert"); 
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userId );
					pstmt.setString(2, password);
					pstmt.setString(3, userName);
					pstmt.setInt(4, age);
					pstmt.setString(5, email);
					pstmt.setString(6, phone);
					pstmt.setString(7, address);
					pstmt.setString(8, String.valueOf(gender)) ;
					pstmt.setString(9,hobby);
//					pstmt.setString(10, String.valueOf(new Date()));
					
					result = pstmt.executeUpdate();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
		
		return result;
	}
}
