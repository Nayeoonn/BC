package com.example.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.server.dto.Board;
import com.example.server.dto.Files;
import com.example.server.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private FileService fileService;

    @Override
    public List<Board> list() throws Exception {

        return boardMapper.list();
    }

    @Override
    public Board insert(Board board) throws Exception {
        int result = boardMapper.insert(board);
        log.info("result: {}", result);
        int newNo = board.getNo();
        log.info("newNo: {}",newNo);
        Board newBoard = boardMapper.select(newNo);
        log.info(newBoard.toString());

        // 파일 업로드
        Files fileInfo = new Files();
        String parentTalbe = "board";
        fileInfo.setParentTable(parentTalbe);
        fileInfo.setParentNo(newNo);

        List<MultipartFile> fileList = board.getFiles();

        if ( fileList == null || fileList.isEmpty()) {
            log.info("첨부한 파일이 없습니다.");
            return newBoard;
        }

        List<Files> uploadedFileList = fileService.uploadFiles(fileInfo, fileList);
        log.info("-----------!!!!!!!!!!!!!!" + uploadedFileList);
        if ( uploadedFileList == null || uploadedFileList.isEmpty()) {
            log.info("파일 업로드 실패...");
        }
        else {
            log.info("파일 업로드 성공");
            log.info(uploadedFileList.toString());
        }

        return newBoard;
    }

    @Override
    public Board select(int no) throws Exception {

        return boardMapper.select(no);
    }

    @Override
    public int update(Board board) throws Exception {

        return boardMapper.update(board);
    }

    @Override
    public int delete(int no) throws Exception {

        return boardMapper.delete(no);
    }

    
}