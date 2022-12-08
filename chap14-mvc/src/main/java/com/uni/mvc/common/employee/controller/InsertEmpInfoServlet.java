package com.uni.mvc.common.employee.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.mvc.common.employee.model.dto.EmployeeDTO;
import com.uni.mvc.common.employee.model.service.EmployeeService;

/**
 * Servlet implementation class InsertEmpInfoServlet
 */
@WebServlet("/employee/insert")
public class InsertEmpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEmpInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 개인정보
		String name = request.getParameter("empName");
		String empNo = request.getParameter("empNo");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		// 코드
		String dept = request.getParameter("deptCode");
		String job = request.getParameter("jobCode");
		String salLevel = request.getParameter("salLevel");
		// 급여, 고용일
		int salary = Integer.parseInt(request.getParameter("salary"));
		int bonus = Integer.parseInt(request.getParameter("bonus"));
		String managerId = request.getParameter("managerId");
		Date hire = java.sql.Date.valueOf(request.getParameter("hireDate"));
		
		EmployeeDTO registerEmp = new EmployeeDTO();
		registerEmp.setEmpName(name);
		registerEmp.setEmpNo(empNo);
		registerEmp.setEmail(email);
		registerEmp.setPhone(phone);
		registerEmp.setDeptCode(dept);
		registerEmp.setJobCode(job);
		registerEmp.setSalLevel(salLevel);
		registerEmp.setSalary(salary);
		registerEmp.setBonus(bonus);
		registerEmp.setManagerId(managerId);
		registerEmp.setHireDate(hire);
		
		int result = new EmployeeService().insertEmp(registerEmp);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("successCode", "insertEmp");
		}else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "직원 추가 실패!");
		}
		request.getRequestDispatcher(path).forward(request, response);		
	}

}
