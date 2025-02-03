package com.example.todo.service;

import com.example.todo.model.SubTodo;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.myspringframework.annotations.Autowired;
import org.myspringframework.annotations.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo getTodo(Long id) {
        return todoRepository.getTodo(id).orElseThrow(() -> new RuntimeException("Todo not found " + id));
    }

    public Todo done(Long id) {
        Todo todo = getTodo(id);
        todo.setDone(true);
        todo.getSubTodos().forEach(SubTodo::done);
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.getAllTodos();
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.delete(id);
    }
}
