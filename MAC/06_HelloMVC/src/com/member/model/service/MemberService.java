package com.member.model.service;

import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;
import static com.common.JDBCTemplate.close;
public class MemberService {
	
	private MemberDao dao=new MemberDao();
	
	
	public Member login(String userId, String pw) {
		Connection conn=getConnection();
		Member m=dao.login(conn,userId,pw);
		close(conn);
		return m;
	}
	
	public int insertMember(Member m){
		
		Connection conn=getConnection();
		int result=dao.insertMember(conn,m);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);		
		
		return result;
	}

	
	
	public Member checkDuplicateId(String userId) {
		
		
			Connection conn = getConnection();
			
			System.out.println("sev in"+userId);
			Member m = dao.checkDuplicateId(userId, conn);
			
			
			System.out.println(m);
			close(conn);
			
		return m;
		
		
	}

	public int updateMember(Member mUpdate) {
		Connection conn = getConnection();
		
		int result = dao.updateMember(mUpdate, conn);
		if(result>0) {
			
			commit(conn);
		} else {
			
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int memberDelete(String userId) {
		
		Connection conn =  getConnection();
		
		
		int result = dao.memberDelete(userId, conn);
		
		if(result >0) {
			commit(conn);
		} else {
			
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int checkPw(String userId,  String passwordOld, String passwordNew) {
		// TODO Auto-generated method stub
			Connection conn = getConnection();
			System.out.println("Service "+userId + " " + passwordOld + " " + passwordNew);
			int result = dao.checkPw(userId,passwordOld, passwordNew, conn);
			if(result>0) {
				commit(conn);
			}  else {
				rollback(conn);
			}
			
			
			close(conn);
		
		return result;
	}
	
	
	
}






