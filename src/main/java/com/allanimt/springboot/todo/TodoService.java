package com.allanimt.springboot.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//this is the Service Layer! (For the Business Logic)
@Service
public class TodoService {
    /* Comment this, because the todos are now handled by the database
    private List<Todo> data = new ArrayList<>(
            Arrays.asList(
                    new Todo(1, "first title", "first Description"),
                    new Todo(2, "second title", "second Description"),
                    new Todo(3, "third title", "third Description"))
    );
    */
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        //return data;
        return todoRepository.findAll();
    }

    public Todo getTodoById(String id) {
        /*
        for (Todo todo : data) {
            if (todo.getId() == id) return todo;
        }
        return null;
        */
        return todoRepository.findById(id).get();
    }

    public Todo save(Todo todo) {
        //return data.add(todo);
        return todoRepository.insert(todo);
    }

    public void delete(String id) {
        /*
        for (Todo todo : data) {
            if (todo.getId() == id) {
                data.remove(todo);
            }
        }
         */
        todoRepository.deleteById(id);
    }
}

