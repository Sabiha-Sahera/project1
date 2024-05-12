package com.prog.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prog.entity.UserDtls;
import com.prog.repository.UserRepository;
import com.prog.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;	 
	
	@GetMapping("")
	public String logo() 
	{
		return "logo";
	}	
	
	@GetMapping("Signup")
	public String home() 
	{
		return "index";
	}	
	@PostMapping("/register")
	public String register (@ModelAttribute UserDtls u)
	{		
		System.out.print(u);
		
		repo.save(u);
		return "redirect:/";		
	}
	
	@Autowired
	public LoginService userService;
	
	@GetMapping("/home")
	public String home1() {
		return "home";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		
		ModelAndView mav=new ModelAndView("login");
		mav.addObject("user", new UserDtls());
		
		return mav;
		
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") UserDtls user) {
		
		UserDtls oauthUser =userService.login(user.getEmail(), user.getPassword());
		System.out.print(oauthUser);
		if(Objects.nonNull(oauthUser)) {
			return "redirect:/home";
		}else {
			return "redirect:/login";
		}
		
	}	
	
   @RequestMapping(value= {"/logout"},method =RequestMethod.POST)
  public String logout(HttpServletRequest request,HttpServletResponse response) {
	return "redirect:/login";
	  
  }
  }
