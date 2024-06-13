package com.example.todo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.todo.dto.Todo;

@Mapper
public interface TodoMapper {
    public List<Todo> list();

    public Todo select(int no);
    
    public int insert(Todo todo);

    public int update(Todo todo);

    public int delete(int no);
}
