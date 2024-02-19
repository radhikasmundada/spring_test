package com.example.Spring_accessment.service;

import com.example.Spring_accessment.exceptions.EntityIsAlreadyExistException;
import com.example.Spring_accessment.exceptions.EntityNotFoundException;
import com.example.Spring_accessment.models.ToDoList;
import com.example.Spring_accessment.repository.IToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private IToDoRepository toDoRepository;

    // fetch all ToDoList
    public List<ToDoList> getAllToDoList() {
        return toDoRepository.findAll();
    }

    // fetch ToDoList by it's id
    public ToDoList getToDoListById(Long id) {
        Optional<ToDoList> toDoList = toDoRepository.findById(id);
        if (toDoList.isPresent()) {
            return toDoList.get();
        }
        throw new EntityNotFoundException("ToDo list item with given ID is not present");
    }

    // create ToDoList
    public ToDoList createToDoList(ToDoList toDoList) {
        ToDoList newToDoList = toDoRepository.save(toDoList);
        return newToDoList;
    }

    // delete ToDoList item by it's id
    public void deleteToDoListItemById(Long id) {
        Optional<ToDoList> toDoList = toDoRepository.findById(id);
        if (toDoList.isPresent()) {
            toDoRepository.deleteById(id);
        }
    }

    // update ToDoList
    public ToDoList updateToDoList(ToDoList toDoList) {

        Optional<ToDoList> optionalToDoList = toDoRepository.findById(toDoList.getId());

        if (optionalToDoList.isPresent()) {
            optionalToDoList.get().setTitle(toDoList.getTitle());
            ToDoList updateToDoList = toDoRepository.save(optionalToDoList.get());
            return updateToDoList;
        } else {
            throw new EntityIsAlreadyExistException("ToDoList is already exists");
        }
    }
}
