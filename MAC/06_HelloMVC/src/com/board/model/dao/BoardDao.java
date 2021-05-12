package com.board.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import static com.common.JDBCTemplate.*;

import com.board.model.vo.*;
import com.common.*;

public class BoardDao {
	private Properties prop = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public BoardDao() {
		prop = new Properties();
		try {
			String path = JDBCTemplate.class.getResource("/sql/board_sql.properties").getPath();
			prop.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public List<Board> showAll(Connection conn, int cPage, int numPerPage) {
		List<Board> result = new ArrayList();
		Board b = null;
			try {
				pstmt = conn.prepareStatement(prop.getProperty("boardshowall"));
				pstmt.setInt(1, (cPage-1)*numPerPage+1);
				pstmt.setInt(2, cPage*numPerPage);
				
				rs= pstmt.executeQuery();
				while(rs.next()) {
					b = new Board();
					b.setBoardNo(rs.getString("BOARD_NO"));
					b.setBoardTitle(rs.getString("BOARD_TITLE"));
					b.setBoardWriter(rs.getString("BOARD_WRITER"));
					b.setBoardContent(rs.getString("BOARD_CONTENT"));
					b.setBoardOriginalFileName(rs.getString("BOARD_ORIGINAL_FILENAME"));
					b.setBoardRenameFileName(rs.getString("BOARD_RENAMED_FILENAME"));
					b.setBoardDate(rs.getString("BOARD_DATE"));
					b.setBoardReadCount(rs.getInt("BOARD_READCOUNT"));
					
					result.add(b);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		
		
		
		
		return result;
	}

	public int showAllCount(Connection conn) {
		int resultCount = 0;
		
			try {
				pstmt = conn.prepareStatement(prop.getProperty("boardshowallcount"));
				rs=pstmt.executeQuery();
				if(rs.next()) {
					resultCount = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			
			
		
		return resultCount;
	}

	public Board boardDetail(int no, Connection conn) {
		Board result = null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("boardDetail"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result = new Board();
				result.setBoardNo(rs.getString("BOARD_NO"));
				result.setBoardTitle(rs.getString("BOARD_TITLE"));
				result.setBoardWriter(rs.getString("BOARD_WRITER"));
				result.setBoardContent(rs.getString("BOARD_CONTENT"));
				result.setBoardOriginalFileName(rs.getString("BOARD_ORIGINAL_FILENAME"));
				result.setBoardRenameFileName(rs.getString("BOARD_RENAMED_FILENAME"));
				result.setBoardDate(rs.getString("BOARD_DATE"));
				result.setBoardReadCount(rs.getInt("BOARD_READCOUNT"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}

	public int boardDetailReadCount(int count, Connection conn, int no) {
		int result =0; 
		try {
			pstmt= conn.prepareStatement(prop.getProperty("boardReadCount"));
			pstmt.setInt(1, count);
			pstmt.setInt(2, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	public int createBoard(Connection conn, Board b) {
		// TODO Auto-generated method stub
		int result = 0;
			try {
				pstmt=conn.prepareStatement(prop.getProperty("boardinsert"));
				pstmt.setString(1, b.getBoardTitle());
				pstmt.setString(2, b.getBoardWriter());
				pstmt.setString(3, b.getBoardContent());
				pstmt.setString(4, b.getBoardOriginalFileName());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		
		
		System.out.println("dao" + result);
		return result;
	}
}
