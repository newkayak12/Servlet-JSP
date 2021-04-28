package com.member.model.service;



import static com.common.JDBCTemplate.*;

import java.sql.Connection;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;

public class MemberService {
		MemberDao memDao = new MemberDao();
		Member m = null;
		Connection conn = null;
	public Member login(String userId, String pwd) {
		
		conn = getConnection();
		 m = memDao.login(userId, pwd, conn);
		 
		 close(conn);
		 
		 return m;
	}

}
