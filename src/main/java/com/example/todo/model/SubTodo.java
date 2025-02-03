package com.example.todo.model;

public class SubTodo {
    private Long id;
    private String content;
    private boolean isDone;

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
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void done() {
        isDone = true;
    }

    @Override
    public String toString() {
        return "SubTodo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}