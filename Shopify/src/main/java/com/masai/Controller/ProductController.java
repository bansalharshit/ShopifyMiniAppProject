package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CategoryNotFoundException;
import com.masai.Exception.ProductNotFoundException;
import com.masai.Model.Category;
import com.masai.Model.Product;
import com.masai.Services.ProductService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductController {

	@Autowired
	private ProductService pService;
	
	@GetMapping("/product")
	public List<Product> getAllProduct() throws ProductNotFoundException{
		return pService.getAllProduct();
	}


    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product product2 = pService.addProduct(product);
        return new ResponseEntity<Product>(product2, HttpStatus.OK); 
        		}

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> removeProduct(@PathVariable int productId) throws ProductNotFoundException {
        pService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
