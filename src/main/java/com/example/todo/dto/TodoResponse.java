package com.example.todo.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TodoResponse {
    private Long id;
    private String title;
    private String description;
    private Boolean done;
    private Boolean important;
    private LocalDate dueDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<SubTodoResponse> subTodos;

    // 기본 생성자
    public TodoResponse() {
    }

    // Getter / Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getDone() {
        return done;
    }
    public void setDone(Boolean done) {
        this.done = done;
    }
    public Boolean getImportant() {
        return important;
    }
    public void setImportant(Boolean important) {
        this.important = important;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public List<SubTodoResponse> getSubTodos() {
        return subTodos;
    }
    public void setSubTodos(List<SubTodoResponse> subTodos) {
        this.subTodos = subTodos;
    }
}
