package com.mit.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.ProductDAO;
import com.mit.model.Product;

@EnableTransactionManagement
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;		
	}
	

	@Transactional
	public List<Product> getAllProduct() {
		
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Transactional
	public boolean saveProduct(Product product) {
		try
		{
			
		sessionFactory.getCurrentSession().save(product);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean updateProduct(Product product) {
		try
		{
		sessionFactory.getCurrentSession().update(product);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteProduct(Product category) {
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
	public boolean deleteProduct(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getProductById(id));
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public Product getProductById(String id) {
		
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where id ='"+ id +"'" ).uniqueResult();// uniqueresult() or list().get(0);
	}

	@Transactional
	public Product getProductByName(String name) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where id ="+ name +"" ).list().get(0);
	}



}
