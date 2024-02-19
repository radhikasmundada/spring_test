package com.example.Spring_accessment.repository;

import com.example.Spring_accessment.models.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Here I stands for Interface
@Repository
public interface IToDoRepository extends JpaRepository<ToDoList, Long> {
}

