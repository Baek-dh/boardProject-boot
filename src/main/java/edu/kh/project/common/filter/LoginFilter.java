package edu.kh.project.common.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("로그인 필터 동작");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		if( session.getAttribute("loginMember") == null) {
			
			// 타임리프에서 #session을 이용해서 session 객체에 직접 접근할 수 있는 방법은 boot3.0에서 제거됨
			
			// RedirectAttributes를 필터에서 얻어오기 위한 RequestContextUtils.getRedirectAttributes()는 boot3.0에서 제거됨
			
			// 쉬운 방법을 위해서 loginError로 리다이렉트 후 해당 컨트롤러에서 RedirectAttributes를 만들어 message를 만들어 메인페이지로 리다이렉트함
			resp.sendRedirect("/loginError");
		} 
		
		else {
			chain.doFilter(request, response);
		}
		
	}

}
