package com.example.todo.dto;

public class SubTodoRequest {
    private String content;
    private boolean done;

    public SubTodoRequest() {
    }

    // Getter / Setter
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
