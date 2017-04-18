package com.mit.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.CartDAO;
import com.mit.model.Cart;
import com.mit.model.Category;
import com.mit.model.Supplier;

@EnableTransactionManagement
@Repository("cartDAO")
public class CartDAOImple implements CartDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDAOImple(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;		
	}

	public List<Cart> getAllCart() {
		return sessionFactory.getCurrentSession().createQuery("from Cart").list();

	}

	@Transactional
	public boolean saveCart(Cart cart) {
		try
		{
		sessionFactory.getCurrentSession().save(cart);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCart(Cart cart) {
		try
		{
		sessionFactory.getCurrentSession().update(cart);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteCart(Cart cart) {
		try
		{
		sessionFactory.getCurrentSession().delete(cart);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCart(int id) {
		try {
			sessionFactory.getCurrentSession().delete(getCartById(id));
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Cart getCartById(int id) {
		return (Cart) sessionFactory.getCurrentSession().createQuery("from Cart where cartId ='"+ id +"'" ).uniqueResult();// uniqueresult() or list().get(0);

	}

	public int getTotalAmount(int cartID) {
		Cart cart;
		cart=(Cart) sessionFactory.getCurrentSession().createQuery("from Cart where cartId='"+cartID+"'" ).uniqueResult();
		return cart.getTotalCost();
	}

	@Transactional
	public List<Cart> getCartsOfUser(String userId) {
		return sessionFactory.getCurrentSession().createQuery("from Cart where userID='"+userId+"'" ).list();
	}

	public String getCartStatus(int cartId) {
		return (String) sessionFactory.getCurrentSession().createQuery("select cartStatus from Cart where cartID='"+cartId+"'").uniqueResult();
	}

	@Transactional
	public boolean removeProductFromCart(String productID, int cartID) 
	{
		try
		{
			Cart cart= (Cart) sessionFactory.getCurrentSession().createQuery("from Cart where cartID='"+cartID+"' and proID='"+productID+"'").uniqueResult();
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
			System.err.println(e);
			return false;
		}
	}

}