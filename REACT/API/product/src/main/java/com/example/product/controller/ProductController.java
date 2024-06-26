package com.example.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.dto.Product;
import com.example.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    
    @GetMapping()
    public ResponseEntity<?> getAllProduct() {
        try {
            List<Product> productList = productService.list();
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllread(@PathVariable("id") String id) {
        try {
            Product product = productService.select(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping()
    public ResponseEntity<?> insert(@RequestBody Product product) {
        try {
            int result = productService.insert(product);
                return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Product product) {
        try {
            int result = productService.update(product);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        try {
            int result = productService.delete(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


// package com.example.product.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.product.dto.Product;
// import com.example.product.service.ProductService;

// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @CrossOrigin(origins = "*")
// @RestController
// @RequestMapping("/products")
// public class ProductController {
    
//     @Autowired
//     ProductService productService;

    
//     @GetMapping("")
//     public ResponseEntity<List<Product>> list() throws Exception{

//         List<Product> productList = productService.list();
//         return ResponseEntity.ok(productList);

//     }


//     @GetMapping("/{id}")
//     public ResponseEntity<Product> select(@PathVariable String id) throws Exception{
       
//         Product product = productService.select(id);
//         return ResponseEntity.ok(product);
//     }
    
//     @PostMapping()
//     public ResponseEntity<Integer> insert(Product product) throws Exception {
//         log.info(product.toString());
//         int result = productService.insert(product);
//         return ResponseEntity.ok(result);
//     }
    
//     @PutMapping()
//     public ResponseEntity<Integer> update(Product product) throws Exception{
//         log.info(product.toString());
//         int result = productService.update(product);
//         return ResponseEntity.ok(result);
//     }
    
//     @DeleteMapping("/{no}")
//     public ResponseEntity<Integer> delete(@PathVariable Integer no) throws Exception {
//         int result = productService.delete(no);
//         return ResponseEntity.ok(result);
//     }
// }
