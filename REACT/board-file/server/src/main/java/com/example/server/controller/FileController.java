package com.example.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.dto.Files;
import com.example.server.service.FileService;

import jakarta.servlet.http.HttpServletResponse;


/**
 * 📄 파일
 * ⭐ 파일 업로드
 * ⭐ 파일 다운로드
 * ⭐ 파일 썸네일
 * ⭐ 파일 삭제
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * ⬆ 파일 업로드
     * @param file
     * @return
     */
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Files file) {
        try {
            Files newFileNo = fileService.upload(file);
            return new ResponseEntity<>(newFileNo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 파일 다운로드
     * @param no
     * @param response
     * @throws Exception
     */
    @GetMapping("/{no}")
    public void fileDownload(@PathVariable("no") int no, HttpServletResponse response) throws Exception{
        fileService.download(no, response);
    }
    
}