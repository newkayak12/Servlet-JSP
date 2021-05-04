package com.common.filter;

import javax.security.auth.message.callback.PrivateKeyCallback.*;
import javax.servlet.http.*;

public class DoNotDisturbMeWrapper extends HttpServletRequestWrapper{
	HttpServletRequest rq = null;
	
	public DoNotDisturbMeWrapper(HttpServletRequest request) {
		super(request);
		
		rq = request;
	}
	
	HttpSession session = rq.getSession(false);
	
	@Override
	public String getParameter(String name) {
		
		
		
		
		
		
		return super.getParameter(name);
	}
	
		
	
}