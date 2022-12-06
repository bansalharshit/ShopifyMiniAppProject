package com.masai.Services;

import java.util.List;

import com.masai.Exception.CategoryNotFoundException;
import com.masai.Model.Category;

public interface CategoryService {

	public Category addCategory(Category cat);
	public Category getCategoryById(Integer id)throws CategoryNotFoundException;
	public Category deleteCategoryById(Integer id)throws CategoryNotFoundException;
	public List<Category> getAllCategory()throws CategoryNotFoundException;
	public Category updateCategory(Category category)throws CategoryNotFoundException;
}
