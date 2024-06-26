package com.example.server.service;

import java.util.List;

import com.example.server.dto.Board;

public interface BoardService {
    public List<Board> list () throws Exception; 
    public Board select(int no) throws Exception;
    public int update(Board board) throws Exception;
    public int insert(Board board) throws Exception;
    public int delete(int no) throws Exception;
}

