package com.allanimt.springboot.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {
    private List<Todo> data = Arrays.asList(
            new Todo(1, "first title", "first Description"),
            new Todo(2, "second title", "second Description"),
            new Todo(3, "third title", "third Description")
    );

    @GetMapping(value = {"", "/"})
    public List<Todo> listTodos() {
        //Todo todoobject =  new Todo(1, "first title", "first Description");
        return data;
    }
}
