package edu.kh.project.common.interceptor;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.kh.project.board.model.service.BoardService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardTypeInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(BoardTypeInterceptor.class);
	
	/* 인터셉터 : 
	 * 1. preHandle (전처리) : DipatcherServlet이 컨트롤러를 호출하기 전
	 * 2. postHandle(후처리) : 컨트롤러에서 DispatcherServlet으로 리턴되는 순간(ModelAndView를 통해 작업결과 참조 가능)
	 * 3. afterCompletion(뷰단처리후) : 모든 뷰에서 최종 결과를 생성하는 일을 포함한 모든 작업이 모두 완료된 후 수행.
	 * 								     요청처리 중에 사용한 리소스를 반환(ex. close() )해주기에 적당한 메소드
	 * */
	
	@Autowired
	private BoardService service;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// application scope로 최상위 경로를 얻어올 수 있는 값 세팅
		
		// application 내장 객체 얻어오기
		ServletContext application = request.getServletContext();
	
		if(application.getAttribute("boardTypeList") == null) {
			// 게시판 종류 조회 서비스 호출 후 결과 반환 받기
			List<Map<String, Object>> boardTypeList = service.selectBoardTypeList();
			
			
			application.setAttribute("boardTypeList", boardTypeList);

			System.out.println(boardTypeList);
		}
		System.out.println("인터셉터 동작 : " + request.getRequestURL());
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
		
	}

	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
}
