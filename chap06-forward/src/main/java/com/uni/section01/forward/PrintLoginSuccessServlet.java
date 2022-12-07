package com.uni.section01.forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintLoginSuccessServlet
 */
@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrintLoginSuccessServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post로 forward가 일어난거면 post로 get으로 forward가 일어난다면 get방식

		System.out.println(request);
		System.out.println(response);

		// object타입으로 넘어왔기 때문에 형변환 해줘야한다. ->
		String userId = (String) request.getAttribute("userId");

		response.setContentType("text/html; charset=UTF-8");
		// 표현식
		StringBuilder responseText = new StringBuilder();
		responseText.append("<!doctype html>\n")
					.append("<html>\n")
					.append("<head>\n")
					.append("</head>\n")
					.append("<body>\n")
					.append("<h3 align=\"center\">")
					.append(userId)
					.append("님 환영합니다.</h3>")
					.append("</body>\n")
					.append("</html>\n");
		// 바이트를 문자 형태를 가지는 객체로 바꿔주는 PrintWriter 
		// getWriter로 인스턴스를 얻는다.
		PrintWriter out = response.getWriter();

		out.print(responseText.toString());

		out.flush();
		out.close();
	}

}
