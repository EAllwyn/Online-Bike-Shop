package com.mit.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="cart")
@Component
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartID;
	
	private String userID;
	
	@ManyToOne
	@JoinColumn(name = "userID", nullable = false, updatable = false, insertable = false)
	private User user;
	
	private String address;
	
	private String deliveryName;
	
	private double contactNumber;
	
	private String proID;
	
	private int productQty;
	
	private int prodCost;
	

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="streetName",column=@Column(name="bill_street")),
		@AttributeOverride(name="city",column=@Column(name="bill_city")),
		@AttributeOverride(name="state",column=@Column(name="bill_state")),
		@AttributeOverride(name="pincode",column=@Column(name="bill_pincode"))
	})
	private Address billingAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="streetName",column=@Column(name="ship_street")),
		@AttributeOverride(name="city",column=@Column(name="ship_city")),
		@AttributeOverride(name="state",column=@Column(name="ship_state")),
		@AttributeOverride(name="pincode",column=@Column(name="ship_pincode"))
	})
	private Address shippingAddress;

	private int totalCost;
	
	private int quantity;
	
	private Date dateAdded;
	
	private String cartStatus;
		
	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartId(int cartID) {
		this.cartID = cartID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public double getcontactNumber() {
		return contactNumber;
	}

	public void setcontactNumber(double contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public int getProdCost() {
		return prodCost;
	}

	public void setProdCost(int prodCost) {
		this.prodCost = prodCost;
	}

	
}
