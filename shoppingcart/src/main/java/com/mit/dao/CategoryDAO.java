package com.mit.dao;

import java.util.List;
import com.mit.model.Category;

public interface CategoryDAO {
	
	public List<Category> getAllCategory();
	

	public boolean saveCategory(Category category);
	

	public boolean updateCategory(Category category);
	
	
	public boolean deleteCategory(Category category);
	
	
	public boolean deleteCategory(String id);
	
	
	public Category getCategoryById(String id);
	
	
	public Category getCategoryByName(String name);
	

}
