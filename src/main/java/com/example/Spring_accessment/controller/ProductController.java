package com.example.Spring_accessment.controller;

import com.example.Spring_accessment.beans.ResponseHandler;
import com.example.Spring_accessment.models.Products;
import com.example.Spring_accessment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Object> getProducts() {
        List<Products> products = productService.getAllProducts();
        return ResponseHandler.createResponse("", HttpStatus.OK, products);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Products products = productService.getProductById(id);
        return ResponseHandler.createResponse("Product found", HttpStatus.OK,  products);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(@RequestBody Products products) {
        Object createdProducts = productService.createProducts(products);
        return ResponseHandler.createResponse("New product is created", HttpStatus.CREATED, createdProducts);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        Products products = productService.getProductById(id);
        productService.deleteProductsById(id);
        return ResponseHandler.createResponse("Product Deleted", HttpStatus.OK,  products);
    }

    @PutMapping("/update")
    public  Object updateProducts(@RequestBody Products products){
        Object product1 = productService.updateProduct(products);
        return ResponseHandler.createResponse("Product name is updated", HttpStatus.OK, products);
    }

}
