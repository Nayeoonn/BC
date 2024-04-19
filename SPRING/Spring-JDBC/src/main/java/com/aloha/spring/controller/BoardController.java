package com.aloha.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.spring.dto.Board;
import com.aloha.spring.service.BoardService;

@Controller // 컨트롤러 빈 등록
@RequestMapping("/board") // 클래스 레벨 경로 /board로 지정
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired // 의존성 자동 주입
	private BoardService boardService;

	/**
	 * 게시글 목록
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	// @RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequestMapping("/list") // Spring 4.3버전 사용 가능
	public String list(Model model) throws Exception {
		List<Board> boardList = boardService.list();
		model.addAttribute("boardList", boardList);
		return "board/list"; // board/list.jsp 화면 응답
	}
	
	/** 
	 * 게시글 조회
	 * @param no
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/read")
	public String select(Model model, int no) throws Exception{
		Board board = boardService.select(no);
		model.addAttribute("board", board);
		return "board/read";
		
	}
	
	// 게시글 등록			- /board/insert - [GET]
	@GetMapping("/insert")
	public String insert() throws Exception{
		return "board/insert";
	}
	
	// 게시글 등록 처리		- /board/insert - [POST]
	@PostMapping("/insert")
	public String insertPro(Board board) throws Exception {
		int result = boardService.insert(board);
		logger.info("게시글 등록 요청 - result : " + result);
		return "redirect:/board/list";
	}
	
	// 게시글 수정			- /board/update - [GET]
	@GetMapping("/update")
	public String update(Model model, int no) throws Exception{
		Board board = boardService.select(no);
		model.addAttribute("board", board);
		return "board/update";
	}
	
	// 게시글 수정 처리		- /board/update - [POST]
	@PostMapping("/update")
	public String updatePro(Board board) throws Exception {
		int result = boardService.update(board);
		logger.info("게시글 수정 요청 - result : " + result);
		return "redirect:/board/list";
	}
	
	// 게시글 삭제 처리		- /board/delete - [POST]
	@PostMapping("/delete")
	public String deletePro(int no) throws Exception {
		int result = boardService.delete(no);
		logger.info("게시글 삭제 요청 - result : " + result);
		return "redirect:/board/list";
	}
}
