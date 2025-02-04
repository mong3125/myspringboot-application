package com.example.todo.controllers;


import com.example.todo.dto.TodoRequest;
import com.example.todo.dto.TodoResponse;
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
    public ResponseEntity<TodoResponse> getTodo(@PathVariable("id") Long id) {
        TodoResponse foundTodo = todoService.getTodo(id);
        return new ResponseEntity<>(foundTodo, HttpStatusCode.OK);
    }

    @RequestMapping(value = "/id/{id}/done", method = RequestMethod.PATCH)
    public ResponseEntity<TodoResponse> done(@PathVariable("id") Long id) {
        TodoResponse doneTodo = todoService.done(id);
        return new ResponseEntity<>(doneTodo, HttpStatusCode.OK);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        List<TodoResponse> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatusCode.OK);
    }

    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@RequestBody TodoRequest todoRequest) {
        TodoResponse savedTodo = todoService.createTodo(todoRequest);
        return new ResponseEntity<>(savedTodo, HttpStatusCode.CREATED);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable("id") Long id, @RequestBody TodoRequest todoRequest) {
        TodoResponse updatedTodo = todoService.updateTodo(id, todoRequest);
        return new ResponseEntity<>(updatedTodo, HttpStatusCode.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTodo(@RequestParam("id") Long id) {
        todoService.delete(id);

        return new ResponseEntity<>(HttpStatusCode.NO_CONTENT);
    }
}
