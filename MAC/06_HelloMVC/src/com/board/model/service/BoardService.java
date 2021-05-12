package com.board.model.service;

import java.sql.*;
import java.util.*;
import static com.common.JDBCTemplate.*;

import com.board.model.dao.*;
import com.board.model.vo.*;

public class BoardService {
	private Connection conn = null;
	private BoardDao bd = new BoardDao();
	private List<Board> result = null;
	
	

	public List<Board> showAll(int cPage, int numPerPage) {
		conn = getConnection();
		result = bd.showAll(conn, cPage, numPerPage);
		
		
		close(conn);
		return result;
	}

	public int showAllCount() {

		conn = getConnection();
		
		int result = bd.showAllCount(conn);
		
		close(conn);
		return result;
	}

	public Board boardDetail(int no) {
		conn = getConnection();
		
		Board result = bd.boardDetail(no, conn);
		
		close(conn);
		return result;
	}

	public void boardDetailReadCount(int count, int no) {
		conn= getConnection();
		
		int result = bd.boardDetailReadCount(count,conn, no);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		// TODO Auto-generated method stub
		
	}

	public int createBoard(Board b) {
		// TODO Auto-generated method stub
		conn=getConnection();
		
		int result = bd.createBoard(conn, b);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	
}
