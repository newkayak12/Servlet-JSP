package com.filter;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet Filter implementation class TestFilter
 */
//@WebFilter("*.do")
@WebFilter(servletNames = { "filtertest2"
//	web.xml에 등록한 이름을 기준으로 필터링한다.	
})
	public class TestFilter implements Filter {
	
	    /**
	     * Default constructor. 
	     */
	    public TestFilter() {
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see Filter#destroy()
		 */
		public void destroy() {
			// TODO Auto-generated method stub
		}
	
		/**
		 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
		 */
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			// TODO Auto-generated method stub
			// place your code here
					if( (request.getParameter("userId")==null) || !request.getParameter("userId").equals("admin")) {
//						서버에서 응답이 없을 때 빈 화면이 뜨는데, 
//						요청에 응답이 되면 그냥 끝난다. 그럼 이 request는 사라진다.
						
						HttpServletResponse res = (HttpServletResponse) response;
							res.setContentType("text/html; charset=utf-8");
						PrintWriter out = res. getWriter();
						String html = "<html> <body> <h1 style = 'color: red'> 잘못된 경로로 접근했습니다. </h1>";
							html += "</body> </html>";
							out.print(html);
							
//							query String ?으로 userId=admin추가하니까 필터에 안걸리네...
							
							
							
//							request로부터 파라미터, 세션 다 가져올 수 있죠  얘로 로그인 여부를 체킹할 수 있다구요
//							로그인이 안되어
							
							
			
			
					} else {	
			// pass the request along the filter chain
							chain.doFilter(request, response);
					}
		}
	
		/**
		 * @see Filter#init(FilterConfig)
		 */
		public void init(FilterConfig fConfig) throws ServletException {
			// TODO Auto-generated method stub
		}
	
	}
