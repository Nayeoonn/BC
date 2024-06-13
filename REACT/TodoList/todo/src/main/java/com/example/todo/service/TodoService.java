package com.example.todo.service;

import java.util.List;

import com.example.todo.dto.Todo;

public interface TodoService {
    public List<Todo> list();

    public Todo select(int no);
    
    public int insert(Todo todo);

    public int update(Todo todo);

    public int delete(int no);
}
