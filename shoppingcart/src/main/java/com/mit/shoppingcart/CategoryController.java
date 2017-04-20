package com.mit.shoppingcart;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/selAddCategory")
	public ModelAndView showCategoryAdd()
	{
		log.debug("Start of method showCategoryAdd");
		ModelAndView mv=new ModelAndView("/AddCategory","command", new Category());
		log.debug("End of method showCategoryAdd");
		return mv;
	}
	
	@RequestMapping(value="/addCategory",  method = RequestMethod.POST)
	public ModelAndView addCategoryFunction(@ModelAttribute Category category)
	{
		log.debug("Start of method addCategoryFunction");
		categoryDAO.saveCategory(category);
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("msg", "Category ADDED");
		log.debug("End of method addCategoryFunction");
		return mv;
	}
	
	@RequestMapping("/selEditCategory")
	public ModelAndView showEditCategory(Map<String, Object> map)
	{
		log.debug("Start of method showEditCategory");
		List<Category> categList=categoryDAO.getAllCategory();
		map.put("crList", categList );
		ModelAndView mv=new ModelAndView("/EditCategory",map);
		log.debug("End of method showEditCategory");
		return mv;
	}
	
	@RequestMapping("/findCategory")
	public ModelAndView findCategory(@RequestParam("cID") String cgID, Map<String, Object> map)
	{
		log.debug("Start of method findCategory");
		Category category=categoryDAO.getCategoryById(cgID);
		ModelAndView mv=new ModelAndView("/EditCategory2","command", new Category() );
		mv.addObject("cgFound", category);
		log.debug("End of method findCategory");
		return mv;
	}
	
	@RequestMapping(value="/editCategory",  method = RequestMethod.POST)
	public ModelAndView editCategoryFunction(@ModelAttribute Category category,@RequestParam("ctID") String cgID,@RequestParam("ctName") String cgName,@RequestParam("ctDesc") String cgDesc)
	{
		log.debug("Start of method editCategoryFunction");
		category.setCategoryID(cgID);
		category.setCategoryName(cgName);
		category.setCategorydescription(cgDesc);
		categoryDAO.updateCategory(category);
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("msg", "Category Edited");
		log.debug("End of method editCategoryFunction");
		return mv;
	}
	
	@RequestMapping("/selDeleteCategory")
	public ModelAndView seldeleteCategoryFunction()
	{
		log.debug("Start of method seldeleteCategoryFunction");
		ModelAndView mv=new ModelAndView("/DeleteCategory");
		log.debug("End of method seldeleteCategoryFunction");
		return mv;
	}
	
	@RequestMapping("/deleteCategory")
	public ModelAndView deleteCategory(@RequestParam("cID") String cgID)
	{
		log.debug("Start of method deleteCategoryFunction");
		categoryDAO.deleteCategory(cgID);
		ModelAndView mv=new ModelAndView("/Admin");
		log.debug("End of method deleteCategoryFunction");
		return mv;
	}
	
	@RequestMapping("/selViewCategory")
	public ModelAndView viewCategory(Map<String, Object> map)
	{
		log.debug("Start of method viewCategory");
		List<Category> categList=categoryDAO.getAllCategory();
		map.put("cgList", categList );
		ModelAndView mv=new ModelAndView("/ViewCategory",map);
		log.debug("End of method viewCategory");
		return mv;
	}
	
}
