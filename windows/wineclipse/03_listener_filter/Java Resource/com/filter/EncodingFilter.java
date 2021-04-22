package com.filter;

import java.io.*;

import javax.servlet.*;

// Filter를 적용하기 위해서는 Filter 인터페이스를 구현하면 된다.
public class EncodingFilter implements Filter {

	@Override
		public void destroy() {
			// TODO Auto-generated method stub
			
		}

	@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			// TODO Auto-generated method stub
							System.out.println("Filter 실행");
				
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				
				
				chain.doFilter(request, response);
			
		}

	@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			// TODO Auto-generated method stub
			
		}

}
