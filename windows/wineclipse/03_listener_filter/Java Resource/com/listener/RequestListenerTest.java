package com.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

/**
 * Application Lifecycle Listener implementation class RequestListenerTest
 *
 */


//@WebListener

//필터 때문에 주석함
	public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {
		private int count = 0;
		
	    /**
	     * Default constructor. 
	     */
	    public RequestListenerTest() {
	        // TODO Auto-generated constructor stub
	    }
	
		/**
	     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	     */
	    public void requestDestroyed(ServletRequestEvent sre)  { 
	    				System.out.println("요청이 사라짐");
	    }
	
		/**
	     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
	     */
	    public void attributeRemoved(ServletRequestAttributeEvent arg0)  { 
	         // TODO Auto-generated method stub
	    }
	
		/**
	     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	     */
	    public void requestInitialized(ServletRequestEvent sre)  { 
	    				System.out.println("요청이 들어옴");
	    				System.out.println(sre.getServletContext().getContextPath()); // 애플리케이션 이름이 나옴
	    				System.out.println(((HttpServletRequest) (sre.getServletRequest())).getRequestURL());
			String url =  new String (((HttpServletRequest) (sre.getServletRequest())).getRequestURL());
					if(url.contains("login.do")) {
						count ++;
					}
				sre.getServletRequest().getParameterMap(); 
	    }	
	
		/**
	     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
	     */
	    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
	         // TODO Auto-generated method stub
	    }
	
		/**
	     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
	     */
	    public void attributeReplaced(ServletRequestAttributeEvent arg0)  { 
	         // TODO Auto-generated method stub
	    }
		
	}
