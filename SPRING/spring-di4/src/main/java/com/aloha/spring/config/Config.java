package com.aloha.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aloha.spring.dto.Reply;


// 빈 설정 클래스로 지정
@Configuration
public class Config  {
	
	// 빈 등록 메소드로 지정
	@Bean
	public Reply getReply() {
		return new Reply("제목있음", "작성자있음", "내용있음");
	}
}
