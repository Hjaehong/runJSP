package com.uni.mvc.common.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.mvc.common.employee.model.dto.EmployeeDTO;
import com.uni.mvc.common.employee.model.service.EmployeeService;

/**
 * Servlet implementation class SelectAllEmpInfoServlet
 */
@WebServlet("/employee/list")
public class SelectAllEmpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllEmpInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스 호출
		EmployeeService empService = new EmployeeService();
		// 서비스에서 받은 값을 리스트에 담는다.
		List<EmployeeDTO> emp = empService.selectAllEmp();
		
		String path = "";
		// 값이 제대로 넘어왔는지 확인용
		for(EmployeeDTO e : emp) {
			System.out.println("info" + e);
		}
		if(emp != null) {
			path = "/WEB-INF/views/employee/employeeList.jsp";
			request.setAttribute("empList", emp); //요청값이 empList, 응답값 list
		}else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "직원이 없습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}
