package com.example.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.dto.Todo;
import com.example.todo.mapper.TodoMapper;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoMapper todoMapper;

    @Override
    public List<Todo> list() {
        return todoMapper.list();
    }

    @Override
    public Todo select(int no) {
       return todoMapper.select(no);
    }

    @Override
    public int insert(Todo todo) {
       return todoMapper.insert(todo);
    }

    @Override
    public int update(Todo todo) {
        return todoMapper.update(todo);
    }

    @Override
    public int delete(int no) {
        return todoMapper.delete(no);
    }
    
}
