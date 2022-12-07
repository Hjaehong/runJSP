package com.greedy.section02.sessionlistener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SessionListener 확인용 서블릿 ");
		/* session을 최초 발급받을 시 sessionCreated() 가 동작한다. */ /*테스트할떄 잘안되면 모든 브라우저 닫고 다시 열어서 하자 그래야 새로 발급됨 */
		HttpSession session = request.getSession();
		System.out.println("발급받은 session id : " + session.getId());
		
		
		HttpSession session2 = request.getSession();
		System.out.println("다시 요청한  session id : " + session2.getId());
		/* session에 attribute를 추가할 때 attributeAdded() 메소드가 동작한다. */
		session.setAttribute("username", "honggildong");
		session.setAttribute("age", 20);
		session.setAttribute("gender", "M");//여기까지하고 확인 
		
		/* SessionBoundListener 구현 후 테스트 해야 함  */
		session.setAttribute("user", new UserDTO("honggildong", 20));
		
		/* session에 attribute를 동일한 key로 덮어 쓰는 경우 (value 수정) attributeReplaced() 메소드가 동작한다. */
		session.setAttribute("username", "hong");
		
		/* session에 attribute를 제거할 때 attributeRemoved()가 동작한다. */
		session.removeAttribute("gender");
		
		/* session을 만료하게 되면 sessionDestroyed() 가 동작한다. */
//		session.setMaxInactiveInterval(5);		이게 좀 늦게 동작함
		session.invalidate();		//만료 시 모든 attribute를 지운다.
		
		
		
	}

}
