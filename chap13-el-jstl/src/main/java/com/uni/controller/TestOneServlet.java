package com.uni.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestOneServlet
 */
@WebServlet("/test1")
public class TestOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("name", "홍길동");
		request.setAttribute("age", new Integer(20));
		request.setAttribute("phone", "010-1234-5678");
		
		List<String> items = new ArrayList<>();
		items.add(new String("apple"));
		items.add(new String("banana"));
		items.add(new String("melon"));
		
		request.setAttribute("items", items);
		
		RequestDispatcher view = request.getRequestDispatcher("views/el/testEl1.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
