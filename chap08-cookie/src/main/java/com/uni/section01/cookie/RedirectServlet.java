package com.uni.section01.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// redirect는 url로 받아오기 때문에 get방식으로 받아야한다.

		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		System.out.println("이름 :" + fName + lName);
		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) {
			System.out.println("[cookie] " + cookies[i].getName() + " : " + cookies[i].getValue());

			if ("firstName".equals(cookies[i].getName())) {
				fName = cookies[i].getValue();
			} else if ("lastName".equals(cookies[i].getName())) {
				lName = cookies[i].getValue();
			}
		}

		StringBuilder responseText = new StringBuilder();
		responseText.append("<!doctype html>\n")
					.append("<html>\n")
					.append("<head>\n")
					.append("</head>\n")
					.append("<body>\n")
					.append("<h3>your first name is ")
					.append(fName)
					.append(" and last name is ")
					.append(lName)
					.append("</h3>")
					.append("</body>\n")
					.append("</html>\n");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(responseText.toString());

		out.flush();
		out.close();
	}

}
