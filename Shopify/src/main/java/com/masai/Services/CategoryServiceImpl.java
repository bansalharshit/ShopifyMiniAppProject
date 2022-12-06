package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CategoryNotFoundException;
import com.masai.Model.Category;
import com.masai.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository cRepo;
	
	@Override
	public Category addCategory(Category cat) {
		Category category=cRepo.save(cat);
		return category;
		
		
	}

	@Override
	public Category getCategoryById(Integer id) throws CategoryNotFoundException {
		return cRepo.findById(id).orElseThrow(()->new CategoryNotFoundException("No Category Found With Given category id "+id));
	}

	@Override
	public Category deleteCategoryById(Integer id) throws CategoryNotFoundException {
		Optional<Category> opt=cRepo.findById(id);
		if(opt.isPresent()) {
			Category categoryfound=opt.get();
			cRepo.delete(categoryfound);
			return categoryfound;
		}else
			throw new CategoryNotFoundException("No category found to delete with the given id "+id);
	}

	@Override
	public List<Category> getAllCategory() throws CategoryNotFoundException {
		List<Category> listofcategory=cRepo.findAll();
		if(listofcategory.size()==0) {
			throw new CategoryNotFoundException("No Category List Found");
		}else
			return listofcategory;
	}

	@Override
	public Category updateCategory(Category category) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
