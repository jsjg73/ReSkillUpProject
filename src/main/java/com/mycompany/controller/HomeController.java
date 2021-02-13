package com.mycompany.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/sessionNull")
	public String sessionnull() {
		return "sessionerror";
	}
	
	@RequestMapping(value = "home/{login}", method = RequestMethod.GET)
	public String homeAdmin(HttpSession sess,Model model, @PathVariable("login") String login) {
		
		//직원 : admin
		//제조사 :coc
		//비로그인 :#
		sess.setAttribute("login", login);
		model.addAttribute("login",login);
		
		return "home";
	}
	
}
