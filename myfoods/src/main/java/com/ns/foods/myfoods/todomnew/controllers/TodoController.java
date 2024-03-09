package com.ns.foods.myfoods.todomnew.controllers;

import com.ns.foods.myfoods.todomnew.TodoDTO;
import com.ns.foods.myfoods.todomnew.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/addTodo")
    public ResponseEntity<?> addTodo(@RequestBody TodoDTO todoDTO){
        try {
            todoDTO.setCreatedAt(new Date(System.currentTimeMillis()));
            todoRepository.save(todoDTO);
            return new ResponseEntity<TodoDTO>(todoDTO,HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getAllTodos(){
        List<TodoDTO> todoDTOS = todoRepository.findAll();
        if (!todoDTOS.isEmpty()){
            return new ResponseEntity<List<TodoDTO>>(todoDTOS, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No todos available", HttpStatus.OK);
        }
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> getSingleTodo(@PathVariable("id") String id){
        Optional<TodoDTO> dtoOptional = todoRepository.findById(id);
        if (dtoOptional.isPresent()){
            return new ResponseEntity<>(dtoOptional.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Todo not found with id " +id , HttpStatus.NOT_FOUND);
        }
    }

}
