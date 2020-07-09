package com.allanimt.springboot.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//this is the Controller Layer! (For the HTTP Request)
@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = {"", "/"})
    public List<Todo> fetchAllToDo() {
        //Todo todoobject =  new Todo(1, "first title", "first Description");
        return todoService.getAllTodos();
    }

    @GetMapping(value = "/{id}")
    public Todo fetchTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }
}
