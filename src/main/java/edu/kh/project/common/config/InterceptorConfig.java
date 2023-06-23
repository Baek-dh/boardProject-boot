package edu.kh.project.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.kh.project.common.interceptor.BoardTypeInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Bean
	public BoardTypeInterceptor boardTypeInterceptor() {
		return new BoardTypeInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		System.out.println("인터셉터 생성");
//		WebMvcConfigurer.super.addInterceptors(registry);
		// 가로채는 경로 설정 가능
//        registry.addInterceptor(new BoardTypeInterceptor())
//        .addPathPatterns("/**") // 모든 Path에 대해서 가로챌것이다.
        // .addPathPatterns("/sample") // /sample경로에 대해서만 가로챌것이다.
        //.excludePathPatterns("/sample"); // /sample 경로에 대해서는 Interceptor 가로채지 않을것이다.
//        ;
		
		registry.addInterceptor(boardTypeInterceptor())
		
//		.addPathPatterns("/**") // 가로챌 경로 (기본 값 /**)
        .excludePathPatterns("/css/**", "/images/**", "/js/**"); // 가로채지 않을 경로
	}
	

	
}
