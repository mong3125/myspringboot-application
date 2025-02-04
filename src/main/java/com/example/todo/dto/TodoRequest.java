package com.example.todo.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TodoRequest {
    private String title;
    private String description;
    private Boolean done;
    private Boolean important;
    private LocalDate dueDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<SubTodoRequest> subTodos;

    // 기본 생성자
    public TodoRequest() {
    }

    // Getter / Setter
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
    public List<SubTodoRequest> getSubTodos() {
        return subTodos;
    }
    public void setSubTodos(List<SubTodoRequest> subTodos) {
        this.subTodos = subTodos;
    }
}
