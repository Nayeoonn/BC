package com.aloha.springmybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aloha.springmybatis.dto.Files;
import com.aloha.springmybatis.mapper.FileMapper;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public List<Files> list() throws Exception {
        List<Files> fileList = fileMapper.list();
        return fileList;
    }

    @Override
    public Files select(int boardNo) throws Exception {
        Files files = fileMapper.select(boardNo);
		return files;
    }

    @Override
    public int insert(Files board) throws Exception {
        int result = fileMapper.insert(board);

        if(result > 0) {
            return result;
        }
        return 0;
    }

    @Override
    public int update(Files board) throws Exception {
        int result = fileMapper.update(board);

         if(result > 0) {
             return result;
         }
         return 0;
    }

    @Override
    public int delete(int boardNo) throws Exception {
        int result = fileMapper.delete(boardNo);
        
        if(result > 0) {
            return result;
        }
        return 0;
    }

    @Override
    public List<Files> listByParent(Files file) throws Exception {
        List<Files> fileList = fileMapper.listByParent(file);
        return fileList;
    }

    @Override
    public int deleteByParent(Files file) throws Exception {
        int result = fileMapper.deleteByParent(file);
        return result;
    }

    @Override
    public int upload(String parentTable, int parentNo, List<MultipartFile> fileList) throws Exception {
        // TODO : 파일 업로드
        throw new UnsupportedOperationException("파일 업로드 구현하세요.");
    }

    @Override
    public int download(int no, HttpServletResponse response) throws Exception {
        // TODO : 파일 다운로드
        throw new UnsupportedOperationException("파일 다운로드 구현하세요.");
    }


    
}