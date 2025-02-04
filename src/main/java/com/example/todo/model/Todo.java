package com.example.todo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Todo {
    private Long id;
    private String title;
    private String description;
    private Boolean done; // null 체크를 위해 Boolean으로 변경
    private Boolean important;
    private LocalDate dueDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<SubTodo> subTodos = new ArrayList<>();

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

    public List<SubTodo> getSubTodos() {
        return subTodos;
    }

    public void setSubTodos(List<SubTodo> subTodos) {
        this.subTodos = subTodos;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", important=" + important +
                ", dueDate=" + dueDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", subTodos=" + subTodos +
                '}';
    }
}
