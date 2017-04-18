package com.mit.dao;

import java.util.List;
import com.mit.model.Product;

public interface ProductDAO {
	
	//get all categories
		public List<Product> getAllProduct();
		
		//create category
		public boolean saveProduct(Product product);
		
		//update category
		public boolean updateProduct(Product product);
		
		//delete category
		public boolean deleteProduct(Product product);
		
		//delete category
		public boolean deleteProduct(String id);
		
		//get category by id
		public Product getProductById(String id);
		
		//get category by name
		public Product getProductByName(String name);

}
