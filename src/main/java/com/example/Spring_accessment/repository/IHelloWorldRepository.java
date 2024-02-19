package com.example.Spring_accessment.repository;

import com.example.Spring_accessment.models.HelloWorld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Here I stands for Interface
@Repository
public interface IHelloWorldRepository extends JpaRepository<HelloWorld,Long> {

}
