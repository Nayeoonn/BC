package com.aloha.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aloha.spring.config.Config;
import com.aloha.spring.dto.Board;
import com.aloha.spring.dto.Reply;
import com.aloha.spring.dto.User;

@Controller
public class BeanController {
	
	// @RequestMapping
	// * /bean 으로 GET 방식 요청이 오면 실행되는 메소드로 지정
	@RequestMapping(value = "/bean", method = RequestMethod.GET)
	public String bean(Model model) {
		
		// 패키지 이름 지정을 지정하여 컨텍스트 객체 생성
		ApplicationContext context = new AnnotationConfigApplicationContext("com.aloha.spring"); // 패키지 이름 지정
		// 컨텍스트로 부터 등록된 빈을 가져오기
		Board board = context.getBean(Board.class);
		model.addAttribute("board", board);
		
		// 자바 빈 설정 파일 컨텍스트 객체 생성
		ApplicationContext context2 = new AnnotationConfigApplicationContext(Config.class);
		Reply reply = context2.getBean(Reply.class);
		model.addAttribute("reply", reply);
		
		// XML 설정 파일로 부터 컨텍스트 객체 생성
		ApplicationContext context3 = new ClassPathXmlApplicationContext("/main/java/com/aloha/spring/config/config.xml"); // XML 파일 경로 지정
		User user = context3.getBean(User.class);
		model.addAttribute("user", user);
		
		return "bean";
	}
}



















