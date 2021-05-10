package com.task_emp.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.*;
import java.util.*;

import com.task_emp.model.dao.*;
import com.task_emp.model.vo.*;

public class EmployeeService {
	private Connection  conn = null; 
	private EmployeeDao dao = null;
	public List<Employee> searchAll() {
		// TODO Auto-generated method stub
		conn = getConnection();
		
		List<Employee> result = dao.seachAll(conn);
		
		close(conn);
		return result;
	}

}
