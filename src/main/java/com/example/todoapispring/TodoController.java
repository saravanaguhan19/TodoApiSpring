package com.example.todoapispring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    public static List<Todo> todoList;
    public static final  String TODO_NOT_FOUND = "todo not found";

    public TodoController (){
        this.todoList = new ArrayList<>();
        todoList.add(new Todo(1,false ,"this is dummy 1 todo" ,231 ));
        todoList.add(new Todo(2,true ,"this is dummy 2 todo" ,232 ));
    }
    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Todo> getTodos(){
        return todoList;
    }

    @PostMapping ("/todos")

    public ResponseEntity<Todo> createTodo (@RequestBody Todo newTodo){

        todoList.add(newTodo);

        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);

    }
    @GetMapping("/todos/{todoId}")
    public ResponseEntity  <?> getTodoById( @PathVariable long todoId){
        for (Todo todo: todoList) {
            if(todo.getId() == todoId){
                return ResponseEntity.ok(todo);
            }
            
        }
        return ResponseEntity.
        status(HttpStatus.NOT_FOUND).body(TODO_NOT_FOUND);
    }



}
