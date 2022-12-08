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
 * Servlet implementation class UpdateEmpInfoServlet
 */
@WebServlet("/employee/update")
public class UpdateEmpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String empId = request.getParameter("empId");
		Date entDate = java.sql.Date.valueOf(request.getParameter("entDate"));
		System.out.println(empId);
		System.out.println(entDate);
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId(empId);
		dto.setEntDate(entDate);
		
		EmployeeService employeeService = new EmployeeService();
		employeeService.updateEmp(dto);
		
		String path = "";
		if(dto != null) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("successCode", "updateEmp");
		}
		else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "직원 수정 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
