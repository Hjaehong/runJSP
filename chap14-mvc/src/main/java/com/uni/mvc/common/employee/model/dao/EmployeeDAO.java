package com.uni.mvc.common.employee.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uni.mvc.common.employee.model.dto.EmployeeDTO;

public class EmployeeDAO {
	
	public EmployeeDTO selectEmpById(SqlSession session, String empId) {
		
		return session.selectOne("EmployeeDAO.selectEmpById", empId);
	}

	/* employee 테이블의 전체 목록 조회 */
	public List<EmployeeDTO> selectAllEmpList(SqlSession session) {
		
		return session.selectList("EmployeeDAO.selectAllEmpList");
	}

	/* employee 테이블에 insert 하는 메소드 */
	public int insertEmp(SqlSession session, EmployeeDTO emp) {
		
		return session.insert("EmployeeDAO.insertEmp", emp);
	}


	public int updateEmp(SqlSession session, EmployeeDTO emp) {
		
		return session.update("EmployeeDAO.updateEmp", emp);
	}


	public int deleteEmp(SqlSession session, String empId) {
		
		return session.delete("EmployeeDAO.deleteEmp", empId);
	}

}











