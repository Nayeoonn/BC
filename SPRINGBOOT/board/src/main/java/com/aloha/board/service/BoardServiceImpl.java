package com.aloha.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aloha.board.dto.Board;
import com.aloha.board.dto.Files;
import com.aloha.board.mapper.BoardMapper;

@Service    // 서비스 역할의 스프링 빈 등록
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private FileService fileService;

    /**
     * 목록 조회
     */
    @Override
    public List<Board> list() throws Exception {
        List<Board> boardList = boardMapper.list();
        return boardList;
    }

    /**
     * 게시글 조회
     * - no 매개변수로 게시글 번호를 전달 받아서
     *   데이터베이스에 조회 요청
     */
    @Override
    public Board select(int no) throws Exception {        
        Board board = boardMapper.select(no);
        // 추가작업
        

        return board;
    }

    /**
     * 게시글 등록
     */
    @Override
    public int insert(Board board) throws Exception {
        int result = boardMapper.insert(board);

        
        // 파일 업로드
        String parentTable = "board";
        int parentNo = boardMapper.maxPk();
        List<MultipartFile> fileList = board.getFile();

        if( !fileList.isEmpty() ) {
            for (MultipartFile file : fileList) {
                if( file.isEmpty() ) continue;

                // 파일 업로드 요청
                Files uploadFile = new Files();               
                uploadFile.setParentTable(parentTable);
                uploadFile.setParentNo(parentNo);
                uploadFile.setFile(file);
                
                fileService.upload(uploadFile);
            }
        }

        return result;
    }


    /**
     * 게시글 수정
     */
    @Override
    public int update(Board board) throws Exception {
        int result = boardMapper.update(board);
        return result;
    }


    /**
     * 게시글 삭제
     */
    @Override
    public int delete(int no) throws Exception {
        int result = boardMapper.delete(no);
        return result;
    }


}

