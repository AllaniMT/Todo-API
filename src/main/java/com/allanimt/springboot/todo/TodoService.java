package com.allanimt.springboot.todo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

//this is the Service Layer! (For the Business Logic)
@Service
public class TodoService {
    private List<Todo> data = Arrays.asList(
            new Todo(1, "first title", "first Description"),
            new Todo(2, "second title", "second Description"),
            new Todo(3, "third title", "third Description")
    );

    public List<Todo> getAllTodos() {
        return data;
    }

    public Todo getTodoById(int id) {
        for (Todo todo : data) {
            if (todo.getId() == id) return todo;
        }
        return null;
    }
}

