package com.mit.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.CategoryDAO;
import com.mit.model.Category;


@EnableTransactionManagement
@Repository("categoryDAO")
public class CategoryDAOImple implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImple(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;		
	}

	@Transactional
	public List<Category> getAllCategory() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	@Transactional
	public boolean saveCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().save(category);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean updateCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().update(category);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().delete(category);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteCategory(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getCategoryById(id));
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Category getCategoryById(String id) {
		System.out.println("Inside get Category by ID");
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id ="+ id +"" ).uniqueResult();// uniqueresult() or list().get(0);
	}

	@Transactional
	public Category getCategoryByName(String name) {
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id ="+ name +"" ).list().get(0);
	}

}
