package edu.kh.project.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
//@EnableWebSecurity
public class SecurityConfig{
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}


/* @Configuration 어노테이션
 * - 스프링 프로젝트 구성을 위한 설정용 Bean을 생성하는 클래스 
 * - 서버 배포 시 스프링 컨테이너에 의해 자동으로 해석됨
 * - 설정용 xml 파일을 java class로 변환한 파일이라고 생각하면 쉬움
 *
 *
 * @Bean 어노테이션
 * - bean으로 등록하고자 하는 객체를 개발자가 수동으로 만들 때 사용하는 어노테이션
 * - @Bean 어노테이션이 작성된 메서드에서 반환된 객체는 스프링 컨테이너가 관리함(IOC)
 * 
 */