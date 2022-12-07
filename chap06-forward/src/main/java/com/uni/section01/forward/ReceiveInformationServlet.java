package com.uni.section01.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceiveInformationServlet
 */
@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// UTF-8로 인코딩
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		System.out.println("userId :" + userId + ", password :" + password);
		request.setAttribute("userId", userId);
		//                      key     value
		RequestDispatcher rd = request.getRequestDispatcher("print"); // PrintLoginSuccessServlet의 어노테이션
		// 어떠한 정보를 저장하고 있다가 다른 페이지에 전달하는 역할, 즉 내부에서 전달하여 ui바뀌지않고
		System.out.println(request);
		System.out.println(response);
		// request, response 객체를 보내는데 깊은 복사가 이루어져서 원본이 바뀌지 않는다.
		// 이 둘을 보내는 이유는 ->
		rd.forward(request, response);
	}

}
