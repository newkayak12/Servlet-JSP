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
							sql = "select * form Member where MEMBER_ID=? AND MEMBER_PWD=?";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, userId);
							pstmt.setString(1, password);
							rs = pstmt.executeQuery();
							
								if(rs.next()) {
										m = new Member();
										m.setMemberId(rs.getString("member_id"));
										m.setMemberPwd(rs.getString("member_pwd"));
								}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
						try {
							rs.close();
							pstmt.close();
						} catch (SQLException e) {
						// TODO: handle exception
					}
				}

		return m;
	}

}
