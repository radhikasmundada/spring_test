package com.example.Spring_accessment.models;

import jakarta.persistence.*;

@Entity
@Table(name="customers")
public class HelloWorld {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // To auto increament
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HelloWorld(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "id=" + id +
                '}';
    }
}
