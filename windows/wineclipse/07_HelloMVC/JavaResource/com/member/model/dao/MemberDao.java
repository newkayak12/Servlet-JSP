package com.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import static com.common.JDBCTemplate.*;
import com.member.model.vo.Member;

public class MemberDao {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Member m = null;
	private Properties prop = new Properties();
	private String sql = "";
	
	
	public Member login(String userId, String pwd, Connection connection) {
		
				try {
//						String path = MemberDao.class.getResource("/sql/sql.properties").getPath();
						String path = "C:\\Users\\newka\\OneDrive - 충남대학교\\dev\\Servlet-JSP\\windows\\wineclipse\\07_HelloMVC\\JavaResource\\resource\\sql\\sql.properties";
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
										m.setEnrolldate(new Date());
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
}
