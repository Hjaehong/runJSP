package com.uni.section01.sessino;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		// session id가 유지되는지 확인
		HttpSession session = request.getSession();
		System.out.println("redirect 페이지 session id : " + session.getId());
		
		// Enumeration으로 키값 확인
		Enumeration<String> sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		// session으로 값을 받을땐 session에는 object으로 저장되어 있기때문에 형변환 해줘야한다.
		fName = (String) session.getAttribute("firstName");
		lName = (String) session.getAttribute("lastName");
		//화면 출력용
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Your first name is ");
		out.println(fName);
		out.println(" and last name is ");
		out.println(lName);
		out.println("</h3>");
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();
	}

}
