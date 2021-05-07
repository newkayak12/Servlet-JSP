package com.admin.model.service;


import static com.common.JDBCTemplate.*;

import java.sql.*;
import java.util.*;

import com.admin.model.dao.*;
import com.member.model.vo.*;

public class AdminService {

	private AdminDao dao = new AdminDao();
	private Connection conn = null;
	
	public List<Member> showAllMember(int cPage, int numPerPage) {
		
		conn = getConnection();
		
		List<Member> result = dao.showAllMember(conn, cPage, numPerPage);
		
		close(conn);
		
		
		return  result;
	}
	
	
	
	public int countMember (){
		conn = getConnection();
		int count = dao.countMember(conn);
		close(conn);
		
		return count;
	}
}
