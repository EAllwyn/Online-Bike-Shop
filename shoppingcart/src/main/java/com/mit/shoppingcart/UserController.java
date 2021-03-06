package com.mit.shoppingcart;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mit.dao.CartDAO;
import com.mit.dao.ProductDAO;
import com.mit.dao.UserDAO;
import com.mit.model.Product;
import com.mit.model.User;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	public HttpSession session;
	
	@RequestMapping("/Login")
	public ModelAndView userLogin(@RequestParam("uname") String userid,@RequestParam("upwd") String userpwd)
	{
		log.debug("Start to userlogin");
		User user=userDAO.getUserById(userid);
		ModelAndView mv;
		String pwd=user.getUserPassword();
		if(pwd.equals(userpwd))
		{
			if(user.getUserRole().equals("ROLE_ADMIN"))
			{
				mv=new ModelAndView("/index");
				session.setAttribute("AdminMsg","AdminLoggedIn");
				session.setAttribute("UserName", user.getUserFirstName());
				session.setAttribute("loginMsg", null);
			}
			else
			{
				mv=new ModelAndView("/index");
				session.setAttribute("UserMsg","LoggedIn");
				session.setAttribute("User_Id", user.getUserID());
				session.setAttribute("UserName", user.getUserFirstName());
				session.setAttribute("loginMsg", null);
			}
		}
		else
		{
			mv=new ModelAndView("/index");
			session.setAttribute("loginMsg", "notloggedIn");
			mv.addObject("msg","Invalid Login");
		}
		log.debug("End to userlogin");
		return mv;
	}
	
	@RequestMapping("/goRegister")
	public ModelAndView showRegister()
	{
		log.debug("Start method to showRegister");
		ModelAndView mv=new ModelAndView("/Register","command", new User());
		log.debug("End method to showRegister");
		return mv;
	}
	
	@RequestMapping("/addUser")
	public ModelAndView insertUser(@ModelAttribute User user)
	{
		log.debug("Start method to insertUser");
		user.setUserRole("ROLE_USER");
		userDAO.saveUser(user);
		ModelAndView mv=new ModelAndView("/index");
		log.debug("End method to insertUser");
		return mv;
	}
	
	@RequestMapping("/clickLogout")
	public ModelAndView logoutUser()
	{
		log.debug("Start method to logoutUser");
		ModelAndView mv=new ModelAndView("/index");
		session.removeAttribute("UserMsg");
		session.removeAttribute("UserName");
		session.removeAttribute("AdminMsg");
		session.setAttribute("loginMsg", "notloggedIn");
		log.debug("End method to logoutUser");
		return mv;
	}
	
	
	
	
}