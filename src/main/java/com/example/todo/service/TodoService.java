package com.example.todo.service;

import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.dto.TodoRequest;
import com.example.todo.dto.TodoResponse;
import com.example.todo.mapper.TodoMapper;
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

    public TodoResponse getTodo(Long id) {
        Todo todo = todoRepository.getTodo(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));

        return TodoMapper.toResponse(todo);
    }

    public TodoResponse done(Long id) {
        Todo todo = todoRepository.getTodo(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));

        todo.setDone(true);
        if (todo.getSubTodos() != null) {
            todo.getSubTodos().forEach(SubTodo::markAsDone);
        }

        Todo savedTodo = todoRepository.save(todo);
        return TodoMapper.toResponse(savedTodo);
    }

    public List<TodoResponse> getAllTodos() {
        List<Todo> todos = todoRepository.getAllTodos();

        return todos.stream()
                .map(TodoMapper::toResponse)
                .toList();
    }

    public TodoResponse createTodo(TodoRequest todoRequest) {
        Todo todo = TodoMapper.toEntity(todoRequest);
        Todo savedTodo = todoRepository.save(todo);

        return TodoMapper.toResponse(savedTodo);
    }

    public TodoResponse updateTodo(Long id, TodoRequest todoRequest) {
        Todo existingTodo = todoRepository.getTodo(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));

        if (todoRequest.getTitle() != null) {
            existingTodo.setTitle(todoRequest.getTitle());
        }

        if (todoRequest.getDescription() != null) {
            existingTodo.setDescription(todoRequest.getDescription());
        }

        if (todoRequest.getImportant() != null) {
            existingTodo.setImportant(todoRequest.getImportant());
        }

        if (todoRequest.getDueDate() != null) {
            existingTodo.setDueDate(todoRequest.getDueDate());
        }

        if (todoRequest.getStartTime() != null) {
            existingTodo.setStartTime(todoRequest.getStartTime());
        }

        if (todoRequest.getEndTime() != null) {
            existingTodo.setEndTime(todoRequest.getEndTime());
        }

        if (todoRequest.getDone() != null) {
            existingTodo.setDone(todoRequest.getDone());
        }

        Todo savedTodo = todoRepository.save(existingTodo);
        return TodoMapper.toResponse(savedTodo);
    }

    public void delete(Long id) {
        todoRepository.delete(id);
    }
}
