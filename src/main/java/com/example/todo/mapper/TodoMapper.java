package com.example.todo.mapper;

import com.example.todo.dto.SubTodoRequest;
import com.example.todo.dto.SubTodoResponse;
import com.example.todo.dto.TodoRequest;
import com.example.todo.dto.TodoResponse;
import com.example.todo.model.SubTodo;
import com.example.todo.model.Todo;

import java.util.List;
import java.util.stream.Collectors;

public class TodoMapper {

    // 요청 DTO를 엔티티로 변환 (id는 설정하지 않음)
    public static Todo toEntity(TodoRequest dto) {
        if (dto == null) return null;
        Todo todo = new Todo();
        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());
        todo.setDone(dto.getDone());
        todo.setImportant(dto.getImportant());
        todo.setDueDate(dto.getDueDate());
        todo.setStartTime(dto.getStartTime());
        todo.setEndTime(dto.getEndTime());
        todo.setSubTodos(toSubTodoEntityList(dto.getSubTodos()));
        return todo;
    }

    // 엔티티를 응답 DTO로 변환 (id 포함)
    public static TodoResponse toResponse(Todo todo) {
        if (todo == null) return null;
        TodoResponse dto = new TodoResponse();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        dto.setDone(todo.getDone());
        dto.setImportant(todo.getImportant());
        dto.setDueDate(todo.getDueDate());
        dto.setStartTime(todo.getStartTime());
        dto.setEndTime(todo.getEndTime());
        dto.setSubTodos(toSubTodoResponseDtoList(todo.getSubTodos()));
        return dto;
    }

    // SubTodo 변환
    private static List<SubTodo> toSubTodoEntityList(List<SubTodoRequest> dtos) {
        if (dtos == null) return null;
        return dtos.stream()
                .map(TodoMapper::toEntity)
                .collect(Collectors.toList());
    }

    private static SubTodo toEntity(SubTodoRequest dto) {
        if (dto == null) return null;
        SubTodo subTodo = new SubTodo();
        subTodo.setContent(dto.getContent());
        subTodo.setDone(dto.isDone());
        return subTodo;
    }

    private static List<SubTodoResponse> toSubTodoResponseDtoList(List<SubTodo> subTodos) {
        if (subTodos == null) return null;
        return subTodos.stream()
                .map(TodoMapper::toResponse)
                .collect(Collectors.toList());
    }

    private static SubTodoResponse toResponse(SubTodo subTodo) {
        if (subTodo == null) return null;
        SubTodoResponse dto = new SubTodoResponse();
        dto.setId(subTodo.getId());
        dto.setContent(subTodo.getContent());
        dto.setDone(subTodo.isDone());
        return dto;
    }
}
