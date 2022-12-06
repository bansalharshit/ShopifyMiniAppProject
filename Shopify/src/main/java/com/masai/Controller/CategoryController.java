package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Category;
import com.masai.Services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService cService;
	
	@PostMapping("/category")
	public ResponseEntity<Category>addCategoryHandler(@RequestBody Category category){
		Category cat=cService.addCategory(category);
		return new ResponseEntity<Category>(cat,HttpStatus.CREATED);
	}
}
