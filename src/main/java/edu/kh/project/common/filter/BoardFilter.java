package edu.kh.project.common.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("board 필터 동작");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		// req.getRequestURI() : /board/1, /board2/1/insert, /board/like
		
		String[] arr = req.getRequestURI().split("/");
		
		try {
			String boardCode = arr[2];
			
			// 타임리프의 목적은 잘 다듬어지고 세련된 출력용 템플릿 
			// 로직적인 부분을 view에서 처리하지 않고 back-end에서 처리
			// 게시판 이름 세팅하기
			List<Map<String, Object>> boardTypeList = (List<Map<String, Object>>)(req.getServletContext().getAttribute("boardTypeList"));
			
			for(Map <String,Object> boardType : boardTypeList) {
				
				if((boardType.get("BOARD_CODE") + "").equals(boardCode)) {
					req.setAttribute("boardName", boardType.get("BOARD_NAME"));
				}
			}
			
		} catch(Exception e) {}
		
		
		chain.doFilter(request, response);
		
	}

}
