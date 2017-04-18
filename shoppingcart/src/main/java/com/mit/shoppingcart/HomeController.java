package com.mit.shoppingcart;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mit.model.User;

@Controller
public class HomeController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/")
	public ModelAndView show()
	{
		ModelAndView mv=new ModelAndView("/index");
		session.setAttribute("loginMsg", "notLoggedIn");
		session.setAttribute("UserMsg", null);
		session.setAttribute("AdminMsg", null);
		return mv;
	}
	
	@RequestMapping("/clickHome")
	public ModelAndView showHome()
	{
		ModelAndView mv=new ModelAndView("/index");
		return mv;
	}
	
	@RequestMapping("/clickAbout")
	public ModelAndView showAboutUs()
	{
		ModelAndView mv=new ModelAndView("/AboutUs");
		return mv;
	}
	
	@RequestMapping("/clickLogin")
	public ModelAndView showLogin()
	{
		ModelAndView mv=new ModelAndView("/Login");
		return mv;
	}
	
	@RequestMapping("/clickAdmin")
	public ModelAndView showAdmin()
	{
		ModelAndView mv=new ModelAndView("/Admin");
		return mv;
	}
	
	@RequestMapping("/clickRegister")
	public ModelAndView showRegister()
	{
		ModelAndView mv=new ModelAndView("/Register","command", new User());
		return mv;
	}
	}
