package com.uni.section01.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseTestServlet
 */
@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 문자열을 지속적으로 변경해야하는 경우 builder를 사용하는게 효과적이다.
		// java에서 String은 변경시 새로운 객체를 생성하기 떄문에 성능저하가 우려됨
		StringBuilder responseBuilder = new StringBuilder();
		responseBuilder.append("<!doctype html>\n")
						.append("<html>\n")
						.append("<head>\n")
						.append("</head>\n")
						.append("<body>\n")
						.append("<h1>안녕 servlet response</h1>\n")	
						.append("</body>\n")
						.append("</html>");
		
		System.out.println(response.getContentType());
		// setContentType으로 html이라고 설정해줘야 html 형식으로 나온다
//		response.setContentType("text/html");
		
		System.out.println(response.getCharacterEncoding());
//		response.setCharacterEncoding("UTF-8");
		// 합치기
		response.setContentType("text/html; charset=UTF-8");
		// write을 상속받아 사용하며 다양한 출력방식을 제공한다.
		PrintWriter out = response.getWriter();
		
		out.print(responseBuilder.toString());
		// flush : 버퍼링 되서 아직 기록되지않은 데이터를 콘솔에 모두 출력
		out.flush();
		out.close();
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
