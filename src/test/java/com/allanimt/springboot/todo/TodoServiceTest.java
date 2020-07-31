package com.allanimt.springboot.todo;

import com.allanimt.springboot.error.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class TodoServiceTest {

    @MockBean
    private TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @TestConfiguration
    static class TodoServiceContextConfiguration {

        @Bean
        public TodoService todoService() {
            return new TodoService();
        }
    }

    @Test
    public void testWhenGetAllTodosReturnListOfTodo() {

        //Mockup
        Todo todo1 = new Todo("1", "Title 1", "Description 1");
        Todo todo2 = new Todo("2", "Title 2", "Description 2");
        Todo todo3 = new Todo("3", "Title 3", "Description 3");
        List<Todo> data = Arrays.asList(todo1, todo2, todo3);
        given(todoRepository.findAll()).willReturn(data);

        //Test
        assertThat(todoService.getAllTodos()).hasSize(3).contains(todo1, todo2, todo3);
    }

    @Test
    public void testWhenGetTodoByIdReturnResult() {

        //Mockup
        Todo todo1 = new Todo("1", "Title 1", "Description 1");
        given(todoRepository.findById(anyString())).willReturn(Optional.ofNullable(todo1));
        Todo result = todoService.getTodoById("1");

        //Test
        assertThat(result.getTitle()).containsIgnoringCase("tItLe");
    }

}
