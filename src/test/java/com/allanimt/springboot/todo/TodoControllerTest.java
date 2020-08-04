package com.allanimt.springboot.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //To determine a random Port for the test
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    public void testFetchAllToDo() throws Exception {
        Todo todo1 = new Todo("1", "Title 1", "Description 1");
        Todo todo2 = new Todo("2", "Title 2", "Description 2");
        Todo todo3 = new Todo("3", "Title 3", "Description 3");
        List<Todo> data = Arrays.asList(todo1, todo2, todo3);

        given(todoService.getAllTodos()).willReturn(data);

        mockMvc.perform(get("/api/v1/todos").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].title", equalTo(todo1.getTitle())));
    }

    @Test
    public void testWhenaddNewTodoThenCreateNewTodo() throws Exception {
        Todo todo1 = new Todo("1", "Title 1", "Description 1");

        given(todoService.save(Mockito.any(Todo.class))).willReturn(todo1);
        ObjectMapper myNewObjectMapperObject = new ObjectMapper();
        mockMvc.perform(post("/api/v1/todos").contentType(MediaType.APPLICATION_JSON).content(myNewObjectMapperObject.writeValueAsString(todo1))).andExpect(status().isCreated()).andExpect(jsonPath("$.title", is(todo1.getTitle())));
    }
}
