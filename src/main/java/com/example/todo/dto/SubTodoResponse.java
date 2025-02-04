package com.example.todo.dto;

public class SubTodoResponse {
    private Long id;
    private String content;
    private boolean done;

    public SubTodoResponse() {
    }

    // Getter / Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
}
