package com.allanimt.springboot.todo;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
public class Todo {
    public Todo(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    //Default Constructor
    public Todo() {
        this.timeStamp = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Id
    private String id;

    @NotNull(message = "Title is required")
    @Size(min = 3, message = "Title must at least 3 character")
    private String title;

    @NotNull(message = "Description is required")
    private String description;

    private long timeStamp;
}
