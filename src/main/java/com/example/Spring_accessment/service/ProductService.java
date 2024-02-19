package com.example.Spring_accessment.service;

import com.example.Spring_accessment.exceptions.EntityIsAlreadyExistException;
import com.example.Spring_accessment.exceptions.EntityNotFoundException;
import com.example.Spring_accessment.models.Products;
import com.example.Spring_accessment.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    // fetch all products
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    // fetch product by it's id
    public Products getProductById(Long id) {
        Optional<Products> products = productRepository.findById(id);
        if (products.isPresent()) {
            return products.get();
        }
        throw new EntityNotFoundException("Product with given ID is not present");
    }

    // create new product
    public Products createProducts(Products products) {
        Products newProducts = productRepository.save(products);
        return newProducts;
    }

    // delete the product item by it's id
    public void deleteProductsById(Long id) {
        Optional<Products> products = productRepository.findById(id);
        if (products.isPresent()) {
            productRepository.deleteById(id);
        }
    }

    // update the product
    public Products updateProduct(Products products) {

        Optional<Products> optionalProduct = productRepository.findById(products.getId());

        if (optionalProduct.isPresent()) {
            optionalProduct.get().setProductName(products.getProductName());
            Products updateProduct = productRepository.save(optionalProduct.get());
            return updateProduct;
        } else {
            throw new EntityIsAlreadyExistException("Products is already exists");
        }
    }
}
