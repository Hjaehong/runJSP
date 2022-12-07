package com.greedy.section02.sessionlistener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListenerTest
 *
 */
@WebListener // 웹페이지가 시작될때 자동으로 실행되는 어노테이션
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {

    public SessionListenerTest() {
        /* context가 로드될 시 인스턴스는 생성된다. */
    	System.out.println("session listener 인스턴스 생성");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
         /* 세션이 생성될 때 동작한다.*/
    	System.out.println("session created!!");
    	System.out.println("생성된 session id : " + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         /* 세션이 만료될 시 동작한다. */
    	System.out.println("session destroyed!!");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
         /* session에 attribute가 추가될 때 동작한다. */
    	System.out.println("session attribute added!!");
    	System.out.println("session에서 추가된 attr : " + se.getName() + ", " + se.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	/* session에 attribute가 추가될 때 동작한다. */
    	System.out.println("session attribute removed!!");
    	System.out.println("session에서 제거된 attr : " + se.getName() + ", " + se.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
        /* session의 attribute가 갱신될 때 동작한다. */
    	System.out.println("session attribute replaced!!");
    	System.out.println("session에서 수정된 attr : " + se.getName() + ", " + se.getValue());
    }
	
}
