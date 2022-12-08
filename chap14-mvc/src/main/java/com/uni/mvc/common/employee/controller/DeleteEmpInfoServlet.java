package com.uni.mvc.common.employee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.mvc.common.employee.model.service.EmployeeService;

/**
 * Servlet implementation class DeleteEmpInfoServlet
 */
@WebServlet("/employee/delete")
public class DeleteEmpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmpInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식으로 받아왔기 때문에 인코딩
		request.setCharacterEncoding("UTF-8");
		// main.jsp 페이지에서 받아온 empId 값
		String empId = request.getParameter("empId");
		// 서비스 호출
		int result = new EmployeeService().deleteEmp(empId);
		
		// 위치
		String path = "";
		// 제대로 수행했는지 확인
		if(result > 0) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("successCode", "deleteEmp");
		}else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "직원 삭제 실패!");
		}
	}

}
