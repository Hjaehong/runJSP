package com.uni.mvc.common.employee.model.service;

import static com.uni.mvc.common.mybatis.Tamplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uni.mvc.common.employee.model.dao.EmployeeDAO;
import com.uni.mvc.common.employee.model.dto.EmployeeDTO;

public class EmployeeService {
	
	private final EmployeeDAO empDAO;
	
	public EmployeeService() {
		empDAO = new EmployeeDAO();
	}

	public EmployeeDTO selectOneEmpById(String empId) {
		
		/* SqlSession 생성 */
		SqlSession session = getSqlSession();
		
		/* SqlSession과 함께 정보를 전달하여 조회한다. */
		EmployeeDTO selectedEmp = empDAO.selectEmpById(session, empId);
		
		/* SqlSession 닫기 */
		session.close();
		
		/* 조회 결과를 반환한다. */
		return selectedEmp;
	}
	
	/* 직원 정보 전체 조회용 메소드 */
	public List<EmployeeDTO> selectAllEmp() {
		
		/* SqlSession 생성 */
		SqlSession session = getSqlSession();
		
		/* 비지니스 로직 */
		/* dao 호출하여 조회 */
		List<EmployeeDTO> empList = empDAO.selectAllEmpList(session);
		
		/* SqlSession 닫기 */
		session.close();
		
		/* 수행 결과 반환 */
		return empList;
	}
	
	/* 신규 사원 등록용 메소드 */
	public int insertEmp(EmployeeDTO emp) {
		
		/* SqlSession 생성 */
		SqlSession session = getSqlSession();
		
		/* 비지니스 로직 */
		/* dao 호출하여 삽입 */
		int result = empDAO.insertEmp(session, emp);
		
		/* 트랜젝션 처리 */
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		/* SqlSession 닫기 */
		session.close();
		
		/* 수행 결과 반환 */
		return result;
	}
	
	/* 사원 정보 수정용 메소드 */
	public int updateEmp(EmployeeDTO emp) {
		
		/* SqlSession 생성 */
		SqlSession session = getSqlSession();
		
		/* 비지니스 로직 */
		/* dao 호출하여 수정 */
		int result = empDAO.updateEmp(session, emp);
		
		/* 트랜젝션 처리 */
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		/* SqlSession 닫기 */
		session.close();
		
		/* 수행 결과 반환 */
		return result;
	}
	
	/* 사원 정보 삭제용 메소드 */
	public int deleteEmp(String empId) {
		
		/* SqlSession 생성 */
		SqlSession session = getSqlSession();
		
		/* 비지니스 로직 */
		/* dao 호출하여 삭제 */
		int result = empDAO.deleteEmp(session, empId);
		
		/* 트랜젝션 처리 */
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		/* SqlSession 닫기 */
		session.close();
		
		/* 수행 결과 반환 */
		return result;
	}

}









