package com.example.Spring_accessment.controller;

import com.example.Spring_accessment.beans.ResponseHandler;

import com.example.Spring_accessment.models.ToDoList;
import com.example.Spring_accessment.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/")
    public ResponseEntity<Object> getToDoList() {
        List<ToDoList> toDoLists = toDoService.getAllToDoList();
        return ResponseHandler.createResponse("", HttpStatus.OK, toDoLists);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<?> getToDoListById(@PathVariable Long id) {
        ToDoList products = toDoService.getToDoListById(id);
        return ResponseHandler.createResponse("ToDoList found", HttpStatus.OK,  products);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createToDoList(@RequestBody ToDoList toDoList) {
        Object createdToDoList = toDoService. createToDoList(toDoList);
        return ResponseHandler.createResponse("New ToDoList is created", HttpStatus.CREATED, createdToDoList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteToDoListItemById(@PathVariable Long id) {
        ToDoList toDoList = toDoService.getToDoListById(id);
        toDoService.deleteToDoListItemById(id);
        return ResponseHandler.createResponse("TodoList Item is deleted", HttpStatus.OK,  toDoList);
    }

    @PutMapping("/update")
    public  Object updateProducts(@RequestBody ToDoList toDoList){
        Object updatedToDoList = toDoService.updateToDoList(toDoList);
        return ResponseHandler.createResponse("ToDoList title is updated", HttpStatus.OK, updatedToDoList);
    }

}
