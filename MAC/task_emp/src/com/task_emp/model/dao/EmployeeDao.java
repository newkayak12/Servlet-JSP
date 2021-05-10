package com.task_emp.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import static com.common.JDBCTemplate.*;
import com.task_emp.model.vo.*;

public class EmployeeDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Properties prop  = null;
	
	
	public EmployeeDao() {
	
		prop = new Properties();
			try {
				prop.load(new FileInputStream("/sql.properties"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public List<Employee> seachAll(Connection conn) {
		List<Employee> result = new ArrayList<Employee>();
		Employee emp = null;
		
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectAll"));
			rs = pstmt.executeQuery();
			
				while(rs.next()) {
					emp= new Employee();
					emp.setEmpId(rs.getString(1));
					emp.setEmpName(rs.getString(2));
					emp.setEmpNo(rs.getString(3));
					emp.setEmail(rs.getString(4));
					emp.setPhone(rs.getString(5));
					
					
					emp.setDeptCode(rs.getString(6));
					emp.setJobCode(rs.getString(7));
					emp.setSalLevel(rs.getString(8));
					emp.setSalary(rs.getInt(9));
					emp.setBonus(rs.getString(10));
					emp.setManagerId(rs.getString(11));
					
					emp.setHireDate(rs.getString(12));
					emp.setEntDate(rs.getString(13));
					emp.setEnt(rs.getString(14));
					
					result.add(emp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				close(rs);
				close(pstmt);
				
		}
		
 		
		
		// TODO Auto-generated method stub
		return result;
	}

}
