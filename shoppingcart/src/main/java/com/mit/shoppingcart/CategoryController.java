package com.mit.shoppingcart;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mit.dao.CategoryDAO;
import com.mit.model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/selAddCategory")
	public ModelAndView showCategoryAdd()
	{
		ModelAndView mv=new ModelAndView("/AddCategory","command", new Category());
		return mv;
	}
	
	@RequestMapping(value="/addCategory",  method = RequestMethod.POST)
	public ModelAndView addCategoryFunction(@ModelAttribute Category category)
	{
		categoryDAO.saveCategory(category);
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("msg", "Category ADDED");
		return mv;
	}
	
	@RequestMapping("/selEditCategory")
	public ModelAndView showEditCategory(Map<String, Object> map)
	{
		List<Category> categList=categoryDAO.getAllCategory();
		map.put("crList", categList );
		ModelAndView mv=new ModelAndView("/EditCategory",map);
		return mv;
	}
	
	@RequestMapping("/findCategory")
	public ModelAndView findCategory(@RequestParam("cID") String cgID, Map<String, Object> map)
	{
		Category category=categoryDAO.getCategoryById(cgID);
		ModelAndView mv=new ModelAndView("/EditCategory2","command", new Category() );
		mv.addObject("cgFound", category);
		return mv;
	}
	
	@RequestMapping(value="/editCategory",  method = RequestMethod.POST)
	public ModelAndView editCategoryFunction(@ModelAttribute Category category,@RequestParam("ctID") String cgID,@RequestParam("ctName") String cgName,@RequestParam("ctDesc") String cgDesc)
	{
		category.setCategoryID(cgID);
		category.setCategoryName(cgName);
		category.setCategorydescription(cgDesc);
		categoryDAO.updateCategory(category);
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("msg", "Category Edited");
		return mv;
	}
	
	@RequestMapping("/selDeleteCategory")
	public ModelAndView deleteCategoryFunction()
	{
		ModelAndView mv=new ModelAndView("/DeleteCategory");
		return mv;
	}
	
	@RequestMapping("/deleteCategory")
	public ModelAndView deleteCategory(@RequestParam("cID") String cgID)
	{
		categoryDAO.deleteCategory(cgID);
		ModelAndView mv=new ModelAndView("/Admin");
		return mv;
	}
	
	@RequestMapping("/selViewCategory")
	public ModelAndView viewCategory(Map<String, Object> map)
	{
		List<Category> categList=categoryDAO.getAllCategory();
		map.put("cgList", categList );
		ModelAndView mv=new ModelAndView("/ViewCategory",map);
		return mv;
	}
	
}
