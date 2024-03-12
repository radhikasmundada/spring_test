package com.example.Spring_accessment;

import com.example.Spring_accessment.repository.IHelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringAccessmentApplication implements CommandLineRunner {

    @Autowired
    private IHelloWorldRepository helloWorld;

    public static void main(String[] args) {
        SpringApplication.run(SpringAccessmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

}
