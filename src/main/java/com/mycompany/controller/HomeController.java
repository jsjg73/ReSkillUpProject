package com.mycompany.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.PurSearchDTO;
import com.mycompany.domain.PurposalDTO;
import com.mycompany.persistence.PurposalDAO;
import com.mycompany.service.PurposalService;

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
	// 직원 로그인
	@RequestMapping(value = "home/admin", method = RequestMethod.GET)
	public String homeAdmin(HttpSession sess,Model model) {
		sess.setAttribute("login", "admin");
		model.addAttribute("login","admin");
		return "home";
	}
	
	//제조사 로그인
	@RequestMapping(value = "home/coc", method = RequestMethod.GET)
	public String homeCoC(HttpSession sess,Model model) {
		sess.setAttribute("login", "coc");
		model.addAttribute("login","coc");
		return "home";
	}
	
	//비로그인
	@RequestMapping(value = "home/", method = RequestMethod.GET)
	public String home(HttpSession sess,Model model) {
		
		// 비로그인 세션 값 정하기.
		sess.setAttribute("login", "");
		model.addAttribute("login","");
		
		return "home";
	}
	
}
