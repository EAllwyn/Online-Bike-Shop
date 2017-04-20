package com.mit.shoppingcart;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mit.model.User;

@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/")
	public ModelAndView show()
	{
		log.debug("Start of method show");
		ModelAndView mv=new ModelAndView("/index");
		session.setAttribute("loginMsg", "notLoggedIn");
		session.setAttribute("UserMsg", null);
		session.setAttribute("AdminMsg", null);
		log.debug("End of method show");
		return mv;
	}
	
	@RequestMapping("/clickHome")
	public ModelAndView showHome()
	{
		log.debug("Start of method showHome");
		ModelAndView mv=new ModelAndView("/index");
		log.debug("End of method showHome");
		return mv;
	}
	
	@RequestMapping("/clickAbout")
	public ModelAndView showAboutUs()
	{
		log.debug("Start of method showAboutUs");
		ModelAndView mv=new ModelAndView("/AboutUs");
		log.debug("End of method showAboutUs");
		return mv;
	}
	
	@RequestMapping("/clickLogin")
	public ModelAndView showLogin()
	{
		log.debug("Start of method showLogin");
		ModelAndView mv=new ModelAndView("/Login");
		log.debug("End of method showLogin");
		return mv;
	}
	
	@RequestMapping("/clickAdmin")
	public ModelAndView showAdmin()
	{
		log.debug("Start of method showAdmin");
		ModelAndView mv=new ModelAndView("/Admin");
		log.debug("End of method showAdmin");
		return mv;
	}
	
	@RequestMapping("/clickRegister")
	public ModelAndView showRegister()
	{
		log.debug("Start of method showRegister");
		ModelAndView mv=new ModelAndView("/Register","command", new User());
		log.debug("End of method showRegister");
		return mv;
	}
	}
