package com.notice.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.*;
import java.util.*;

import com.notice.model.dao.*;
import com.notice.model.vo.*;
public class NoticeService {
	private Connection conn = null;
	private NoticeDao dao = new NoticeDao();
	
	public List<Notice> showAll(int cPage, int numPerPage) {
		conn = getConnection();
		
		List<Notice> result = dao.showAll(conn, cPage, numPerPage);
		
		
		return result;
	}

	public Notice showDetail(String noticeNo, String noticeWriter) {
		conn = getConnection();
				
		Notice result = dao.showDetail(conn, noticeNo, noticeWriter);	
				
		close(conn);
		
		
		return result;
	}

	public int showAllCount() {
		conn = getConnection();
		
		int result = dao.showAll(conn);	
				
		close(conn);
		
		
		return result;
	}

}
