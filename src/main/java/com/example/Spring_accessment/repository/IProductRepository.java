package com.example.Spring_accessment.repository;

import com.example.Spring_accessment.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Here I stands for Interface
@Repository
public interface IProductRepository extends JpaRepository<Products, Long> {
}
