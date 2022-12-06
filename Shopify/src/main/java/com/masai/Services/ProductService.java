package com.masai.Services;

import java.util.List;

import com.masai.Exception.CategoryNotFoundException;
import com.masai.Exception.ProductNotFoundException;
import com.masai.Model.Category;
import com.masai.Model.Product;

public interface ProductService {
public Product addProduct(Product product);
public Product deleteProduct(int id)throws ProductNotFoundException;
public Product updateProduct(Product product)throws ProductNotFoundException;
public List<Product> getAllProduct()throws ProductNotFoundException;
public Product getProductById(int id)throws ProductNotFoundException;
}
