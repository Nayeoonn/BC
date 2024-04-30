package com.aloha.springrest.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.springrest.dto.Board;
import com.aloha.springrest.service.BoardService;

import lombok.extern.slf4j.Slf4j;


/*
 *  /board 경로로 요청 왔을 때 처리
 *  [GET]  -  /board/list   : 게시글 목록 화면 
 *  [GET]  -  /board/read   : 게시글 조회 화면 
 *  [GET]  -  /board/insert : 게시글 등록 화면 
 *  [POST] -  /board/insert : 게시글 등록 처리
 *  [GET]  -  /board/update : 게시글 수정 화면 
 *  [POST] -  /board/update : 게시글 수정 처리
 *  [POST] -  /board/delete : 게시글 삭제 처리
 */
@Slf4j                      // 로그 어노테이션 
@Controller                 // 컨트롤러 스프링 빈으로 등록 -> 여러가지 요청 경로 매핑 사용 가능
@RequestMapping("/board")   // 상위 경로 지정하고 싶을 때 클래스 레벨 요청 경로 매핑
                            // - /board/~ 경로의 요청은 이 컨트롤러에서 처리
public class BoardController {

    // 데이터 요청과 화면 출력
    // Controller --> Service (데이터 요청)
    // Controller <-- Service (데이터 전달)
    // Controller --> Model   (모델 등록)
    // View <-- Model         (데이터 출력)
    @Autowired                              // 의존성 자동 주입
    private BoardService boardService;      // @Service를 --Impl에 등록해놨기 때문에

    /**
     * 게시글 목록 조회 화면
     * /board/list
     * model : boardList
     * @return
     * @throws Exception 
     */
    @GetMapping("/list")
    public String list(Model model) throws Exception { // 여기서도 예외 전가
        log.info("[GET] = /board/list");

        // 데이터 요청
        List<Board> boardList = boardService.list();
        
        // 모델 등록
        model.addAttribute("boardList", boardList);

        // 뷰 페이지 지정
        return "/board/list";       // resources/templates/board/list.html
    }

    /**
     * 게시글 조회 화면
     * [GET]
     * /board/read?no=❓
     * - model : board
     * @param model
     * @param no
     * @return
     * @throws Exception 
     */
    // @RequestParam("파라미터명")
    // : 스프링 부트 3.2버전 이하, 생략해도 자동 매핑됨
    // : 스프링 부트 3.2버전 이상, 필수로 명시해야 매핑됨
    @GetMapping("/read")
    public String read(Model model, @RequestParam("no") int no) throws Exception {
        log.info("[GET] - /board/read");

        // 데이터 요청
        Board board = boardService.select(no);
        
        // 모델 등록
        model.addAttribute("board", board);

        return "/board/read";       // /board/read.html
    }

    
    /**
     * 게시글 등록 화면
     * @return
     */
    @GetMapping("/insert")
    public String insert() {
        log.info("[GET] - /board/insert");
        
        return "/board/insert";       // /board/insert.html
    }
    
    
    /**
     * 게시글 등록 처리
     * [POST]
     * /board/insert
     * model : ❌
     * @param board
     * @return
     * @throws Exception
     */
    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {
        
        // 데이터 요청
        int result = boardService.insert(board);
        
        log.info("[POST] - /board/insert");
        log.info(board.toString());

        // 리다이렉트
        // 데이터 처리 성공
        if( result > 0 ) {
            return "redirect:/board/insert";
        }
        // 데이터 처리 실패
        return "redirect:/board/list";
    }
    
    /**
    * 게시글 수정
    * [GET]
    * /board/update
    * - model : update
    * @param model
    * @param no
    * @return
    */
   @GetMapping("/update")
   public String update(Model model, @RequestParam("no") int no) throws Exception {
       log.info("[GET] - /board/update");

       // 데이터 요청
       Board board = boardService.select(no);

       // 모델 등록
       model.addAttribute("board", board);

       return "/board/update";       // /board/update.html
    }

    /**
     * 게시글 수정 처리
     * [POST]
     * /board/update
     * model : board
     * @param board
     * @return
     * @throws Exception
     */
    @PostMapping("/update")
    public String updatePro(Board board) throws Exception {
        
        int result = boardService.update(board);
        
        log.info("[POST] - /board/update");
        log.info(board.toString());

        // 게시글 수정 실패 ➡ 게시글 수정 화면
        if( result > 0 ) {
            return "redirect:/board/list";
        }
        int no = board.getNo();
        return "redirect:/board/update?no=" + no + "&error";

    }    


    /**
     * 게시글 삭제 처리
     * [POST]
     * /board/delete
     * model : ❌
     * @param boardNo
     * @return
     * @throws Exception
     */
    @PostMapping("/delete")
    public String deletePro(@RequestParam("no")int no) throws Exception {

        log.info("[POST] - /board/delete");

        // 데이터 처리
        int result = boardService.delete(no);
        
        // 게시글 삭제 실패 ➡ 게시글 수정 화면
        if( result > 0 ) {
            return "redirect:/board/list";

        }
            return "redirect:/board/update?no=" + no +"&error";

    }

    // 게시글 수정 처리 - [PUT]
    
    @PostMapping("")
    public ResponseEntity<String> putUpdate(Board board){
        log.info("[PUT] - /board");
        log.info(board.toString());
        
        // 게시글 수정 처리
        int result = new Random().nextInt(2);
        
        if(result == 0 )
            return new ResponseEntity<String>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        
    }
    
    
    // 게시글 수정 처리 - [DELETE]
    @DeleteMapping("")
    public ResponseEntity<String> delete(@RequestParam("no") int no){
        log.info("[DELETE] - /board?no=10");
        log.info(no + " 번 게시글 삭제합니다.");
        
        // 게시글 삭제 처리
        int result = new Random().nextInt(2);
        
        if(result == 0 )
            return new ResponseEntity<String>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        
    }
    
}