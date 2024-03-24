package com.example.todoapispring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    public static List<Todo> todos;

    public TodoController (){
        this.todos = new ArrayList<>();
        todos.add(new Todo(1,false ,"this is dummy 1 todo" ,231 ));
        todos.add(new Todo(2,true ,"this is dummy 2 todo" ,232 ));
    }
    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todos;
    }

    @PostMapping ("/todos")
    public Todo createTodo (@RequestBody Todo newTodo){

        todos.add(newTodo);

        return newTodo;

    }




}
