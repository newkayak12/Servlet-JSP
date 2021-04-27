package com.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.model.vo.Member;

public class TestDao {

	public Member login(Connection conn, String userId, String password) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		Member m = null;
	
				try {
							sql = "select * from Member where MEMBER_ID=? AND MEMBER_PWD=?";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, userId);
							pstmt.setString(2, password);
							rs = pstmt.executeQuery();
							
								if(rs.next()) {
										m = new Member();
										m.setMemberId(rs.getString("MEMBER_ID"));
										m.setMemberPwd(rs.getString("MEMBER_PWD"));
										
										System.out.println(m.getMemberId());
										System.out.println(m.getMemberPwd());
								} else {
									System.out.println("fail");
								}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
//				} finally {
//						try {
//							rs.close();
//							pstmt.close();
//						} catch (SQLException e) {
//					}
				}

		return m;
	}

}
