package com.mit.shoppingcart;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mit.dao.CartDAO;
import com.mit.dao.ProductDAO;
import com.mit.dao.UserDAO;
import com.mit.model.Address;
import com.mit.model.Cart;
import com.mit.model.Product;
import com.mit.model.User;;

@Controller
public class CartController {
	
	private static final Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	public HttpSession session;
	
	@RequestMapping("/addProductToCart")
	public ModelAndView goUserCart(@RequestParam("prdAddId") String addprodId)// change params
	{
		log.debug("Start of method goUserCart");
		String path="C:\\Users\\DHANUSHA\\workspace1\\shoppingcart\\src\\main\\webapp\\Resources\\images";
		List<Product> prodList=productDAO.getAllProduct();
		ModelAndView mv=new ModelAndView("/Products");
		String user_Id=(String) session.getAttribute("User_Id");// use session attribute to check if cartid
		Product product=productDAO.getProductById(addprodId);
		Cart cart=new Cart();
		System.out.println(user_Id);
		cart.setUserID(user_Id);
		cart.setProID(product.getProductID());
		cart.setProductQty(1);
		cart.setProdCost(product.getProductCost());
		product.setProductQty(product.getProductQty()-cart.getProductQty());
		productDAO.updateProduct(product);
		cartDAO.saveCart(cart);
		return mv;
	}
	
	@RequestMapping("/clickMyCart")
	public ModelAndView showMyCart(/* request get cartid*/)
	{
		String userid=(String) session.getAttribute("User_Id");
		List<Cart> userCartList=cartDAO.getCartsOfUser(userid);
		ModelAndView mv=new ModelAndView("/MyCart");
		System.out.println(userCartList.size());
		mv.addObject("prList", userCartList);
		//cartDAO.removeProductFromCart("P1", 1);
		//Cart cart=cartDAO.getCartById(1);
		//cartDAO.deleteCart(cart);
		return mv;
	}
	
	/*
	@RequestMapping("/goMyCart")
	public ModelAndView goToCart()
	{
		log.debug("Start of method goToCart");
		int cartID=(Integer)session.getAttribute("CurrentCartID");
		List<ProductOfCart> product_In_Cart=cartDAO.getProductsInCart(cartID);
		for(ProductOfCart prod: product_In_Cart)
		{
			Product product_Add=productDAO.getProductById(s);
			ProductOfCart prOfCart=new ProductOfCart();
			prOfCart.setProductId(product_Add.getProductId());
			prOfCart.setProductName(product_Add.getProductName());
			prOfCart.setProductCost(product_Add.getProductCost());
			prOfCart.setProductQuantity(1);
			product_In_Cart.add(prOfCart);
		}
		ModelAndView mv= new ModelAndView("/viewUserCart");
		mv.addObject("prInCartList", product_In_Cart );
		log.debug("End of method goToCart");
		return mv;
	}
	
	@RequestMapping("/createCartOfUser")
	public ModelAndView createCart(@RequestParam("usID") String userID,@RequestParam("usName") String userName,@RequestParam("addr1") String addrLine1,@RequestParam("addr2") String addrLine2,@RequestParam("addr3") String addrLine3,@RequestParam("addr4") int addrLine4)
	{
		log.debug("Start of method goToCart");
		String path="F:\\EclipseMain\\FinalProject\\Philosophia\\PhilosophiaFrontEnd\\src\\main\\webapp\\Resources\\Images\\";
		List<Product> prodList=productDAO.getAllProduct();
		Cart cart=new Cart();
		User user=userDAO.getUserById(userID);
		System.out.println(user.getUserName());
		Date date=new Date();
		Address address=new Address();
		address.setStreet(addrLine1);
		address.setCity(addrLine2);
		address.setState(addrLine3);
		address.setPincode(addrLine4);
		cart.setUserId(user.getUserID());
		cart.setDelivery_name(userName);
		cart.setBillingAddress(address);
		cart.setUser_contact(user.getUserContact());
		cart.setTotalCost(0);
		cart.setDateAdded(date);
		cart.setCartStatus("Created");
		cartDAO.saveCart(cart);
		ModelAndView mv=new ModelAndView("/ViewProducts");
		mv.addObject("prList", prodList);
		mv.addObject("path", path);
		session.setAttribute("CurrentCartID", cart.getCartID());
		log.debug("Start of method goToCart");
		return mv;
	}
	*/
	@RequestMapping("/removeProductFromCart")// just remove cartid of particular product
	public ModelAndView goRemoveProduct(@RequestParam("prID") String prodId)
	{
		Product product=productDAO.getProductById(prodId);
		Cart cart=new Cart();
		List<Cart> cart_List=cartDAO.getCartsOfUser((String) session.getAttribute("User_Id"));
		for(Cart c: cart_List)
		{
			if(c.getProID().equals(prodId))
			{
				cart=c;
			}
		}
		cartDAO.removeProductFromCart(prodId, cart.getCartID());
		//cart.setTotalCost(cart.getTotalCost()-product.getProductCost());
		//cartDAO.updateCart(cart);
		product.setProductQty(product.getProductQty()+1);
		productDAO.updateProduct(product);
		ModelAndView mv=new ModelAndView("/MyCart");
		List<Cart> userCartList=cartDAO.getCartsOfUser((String) session.getAttribute("User_Id"));
		mv.addObject("prList", userCartList);
		return mv;
	}
	/*
	@RequestMapping("goGenerateBill")
	public ModelAndView goGenerateBill()
	{
		ModelAndView mv=new ModelAndView("/User/CreateCart2");
		return mv;
	}

	@RequestMapping("getShippingAddress")
	public ModelAndView finishCartOrder(@RequestParam("addr1") String addrLine1,@RequestParam("addr2") String addrLine2,@RequestParam("addr3") String addrLine3,@RequestParam("addr4") int addrLine4)
	{
		Address address=new Address();
		address.setStreet(addrLine1);
		address.setCity(addrLine2);
		address.setState(addrLine3);
		address.setPincode(addrLine4);
		Cart cart=cartDAO.getCartById((Integer)session.getAttribute("CurrentCartID"));
		cart.setShippingAddress(address);
		cartDAO.generateBill((Integer)session.getAttribute("CurrentCartID"));
		ModelAndView mv=new ModelAndView("/Home");
		return mv;
	}	*/
}
