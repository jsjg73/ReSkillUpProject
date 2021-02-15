package com.mycompany.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.domain.CocompanyDTO;
import com.mycompany.service.CocompanyService;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	@Autowired
	CocompanyService coc_service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/sessionNull")
	public String sessionnull() {
		return "sessionerror";
	}
	@RequestMapping(value = "home/coc_login", method = RequestMethod.GET)
	public String coc_loginform(HttpSession sess,Model model) {
		
		return "coc_loginform";
	}
	@RequestMapping(value = "home/coc", method = RequestMethod.POST)
	public String coc_login(HttpSession sess, String coc_name, String pwd) {
		List<CocompanyDTO> list = coc_service.cocompanyRead(coc_name);
		if(list.isEmpty()) {
			return "login_fail";
		}
		if(list.get(0).getPwd().equals(pwd)) {
			sess.setAttribute("login", "coc");
			sess.setAttribute("coc_name", coc_name);
			return "home";
		}
		else {
			return "login_fail";
		}
		
	}
	@RequestMapping(value = "home/{login}", method = RequestMethod.GET)
	public String homeAdmin(HttpSession sess,Model model, @PathVariable("login") String login) {
		
		//직원 : admin
		//제조사 :coc
		//비로그인 :none
		sess.setAttribute("login", login);
		model.addAttribute("login",login);
		
		return "home";
	}
	
	
	
}
