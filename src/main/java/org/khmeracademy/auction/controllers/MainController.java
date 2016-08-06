package org.khmeracademy.auction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping({"/home","/index","/"})
	public String homePage(){
		return "index";
	}
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	@RequestMapping("/admin/dashboard")
	public String dashboard(){
		return "/admin/dashboard";
	}
}
