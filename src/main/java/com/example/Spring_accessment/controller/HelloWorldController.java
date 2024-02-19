package com.example.Spring_accessment.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public String helloWorldEndpoint() {
        return "Hello World !!!";
    }
}


