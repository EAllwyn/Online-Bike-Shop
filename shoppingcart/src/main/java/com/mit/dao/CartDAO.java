package com.mit.dao;

import java.util.List;

import com.mit.model.Cart;

public interface CartDAO {
	
public boolean saveCart(Cart cart);
	
	public boolean updateCart(Cart cart);
	
	public boolean deleteCart(Cart cart);
	
	public boolean deleteCart(int cartId);
	
	public Cart getCartById(int cartId);
	
	public List<Cart> getAllCart();
	
	public List<Cart> getCartsOfUser(String userId);
	
	public String getCartStatus(int cartId);
	
	public int getTotalAmount(int cartID);
	
	public boolean removeProductFromCart(String productID, int cartID);

}
