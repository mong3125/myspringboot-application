package com.example.todo.controllers;


import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.myspringframework.annotations.Autowired;
import org.myspringframework.annotations.RestController;
import org.myspringframework.web.bind.annotation.*;
import org.myspringframework.web.http.HttpStatusCode;
import org.myspringframework.web.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Todo> getTodo(@PathVariable("id") Long id) {
        Todo foundTodo = todoService.getTodo(id);
        return new ResponseEntity<>(foundTodo, HttpStatusCode.OK);
    }

    @RequestMapping(value = "/id/{id}/done", method = RequestMethod.PUT)
    public ResponseEntity<Todo> done(@PathVariable("id") Long id) {
        Todo doneTodo = todoService.done(id);
        return new ResponseEntity<>(doneTodo, HttpStatusCode.OK);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatusCode.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo savedTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(savedTodo, HttpStatusCode.CREATED);
    }

    @PutMapping
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(todo);
        return new ResponseEntity<>(updatedTodo, HttpStatusCode.OK);
    }

    @DeleteMapping
    public void deleteTodo(@RequestParam("id") Long id) {
        todoService.delete(id);
    }
}
