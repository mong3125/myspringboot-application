package com.example.todo.repository;

import com.example.todo.model.Todo;
import org.myspringframework.annotations.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TodoRepository {
    private final Map<Long, Todo> todos = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public Optional<Todo> getTodo(Long id) {
        return Optional.ofNullable(todos.get(id));
    }

    public Todo save(Todo todo) {
        if (todo.getId() == null) {
            long newId = idCounter.incrementAndGet();
            todo.setId(newId);
        }
        todos.put(todo.getId(), todo);
        return todo;
    }

    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos.values());
    }

    public void delete(Long id) {
        todos.remove(id);
    }

    public void deleteAll() {
        todos.clear();
    }
}
