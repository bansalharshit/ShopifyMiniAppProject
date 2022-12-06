package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CategoryNotFoundException;
import com.masai.Exception.ProductNotFoundException;
import com.masai.Model.Category;
import com.masai.Model.Product;
import com.masai.Repository.CategoryRepository;
import com.masai.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository pRepo;
	
	
	@Override
	public Product addProduct(Product product){
		
		Product saveProduct=pRepo.save(product);
		return saveProduct;
	}

	@Override
	public Product deleteProduct(int id) throws ProductNotFoundException {
		Optional<Product> opt=pRepo.findById(id);
		if(opt.isPresent()) {
			Product existingProduct=opt.get();
			pRepo.delete(existingProduct);
			return existingProduct;
		}else
			throw new ProductNotFoundException("No Product Exist with the id "+id+" to Delete");
	}

	@Override
	public Product updateProduct(Product product) throws ProductNotFoundException {
		Optional<Product> opt=pRepo.findById(product.getProductId());
		if(opt.isPresent()) {
			Product p=pRepo.save(product);
			return p;
		}else
			throw new ProductNotFoundException("Product Not Found with the id "+product.getProductId()+" to update");
	}

	@Override
	public List<Product> getAllProduct() throws ProductNotFoundException {
		List<Product> allProduct=pRepo.findAll();
		if(allProduct.size()==0)
			throw new ProductNotFoundException("No Product Found in the List");
		else
			return allProduct;
	}

	@Override
	public Product getProductById(int id) throws ProductNotFoundException {
		return pRepo.findById(id).orElseThrow(()->new ProductNotFoundException("No Product Found With The Given Id "+id));
	}

}
