package com.allanimt.springboot.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

//this is the Controller Layer! (For the HTTP Request)
@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Todo>> fetchAllToDo() {
        //Todo todoobject =  new Todo(1, "first title", "first Description");
        List<Todo> result = todoService.getAllTodos();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> fetchTodoById(@PathVariable String id) {

        Todo result = todoService.getTodoById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Todo> addNewTodo(@Valid @RequestBody Todo todo) {
        /*
        if (todoService.save(todo)) {
            return todo;
        }
        return null;
         */
        Todo result = todoService.save(todo);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable String id) {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
