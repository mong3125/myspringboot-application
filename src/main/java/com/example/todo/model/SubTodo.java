package com.example.todo.model;

public class SubTodo {
    private Long id;
    private String content;
    private boolean done;

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

    public void markAsDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        return "SubTodo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", done=" + done +
                '}';
    }
}
