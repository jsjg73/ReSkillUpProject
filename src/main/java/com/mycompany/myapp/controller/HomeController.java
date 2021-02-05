package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.dao.PurposalDAO;
import com.mycompany.myapp.dto.PurposalDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	PurposalDAO dao ;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	// 직원 로그인
	@RequestMapping(value = "home/admin", method = RequestMethod.GET)
	public String homeAdmin(HttpSession sess,Model model) {
		sess.setAttribute("session", "admin");
		model.addAttribute("login","admin");
		return "home";
	}
	
	//제조사 로그인
	@RequestMapping(value = "home/coc", method = RequestMethod.GET)
	public String homeCoC(HttpSession sess,Model model) {
		sess.setAttribute("session", "coc");
		model.addAttribute("login","coc");
		return "home";
	}
	
	//비로그인
	@RequestMapping(value = "home/", method = RequestMethod.GET)
	public String home(HttpSession sess,Model model) {
		
		// 비로그인 세션 값 정하기.
		sess.setAttribute("session", "");
		model.addAttribute("login","");
		
		return "home";
	}
	
	
	@RequestMapping("pur_writeform")
	public String pur_writeform() {
		return "pur_writeform";
	}
	
	@RequestMapping(value="pur_write", method=RequestMethod.POST)
	public String pur_write(PurposalDTO dto) {
		
		//DB 처리 : mybatis
		dao.PurposalInsert(dto);
		
		return "redirect:/pur_list";
	}
	
	@RequestMapping(value="pur_list")
	public String pur_list(Model model) {

		//DB 처리 : mybatis
		List<PurposalDTO> list = dao.purposalList();
		model.addAttribute("list", list);
		
		return "pur_list";
	}
	
	@RequestMapping(value="pur_read")
	public String pur_read(Model model, PurposalDTO dto) {
		
		//DB 처리 : mybatis
		System.out.println(dto.getPdt_name());
		dto = dao.purposalRead(dto);
		model.addAttribute("pur", dto);
		return "pur_read";
	}
	@RequestMapping(value="pur_updateform")
	public String pur_updateform(Model model, PurposalDTO dto) {
		
		//DB 처리 : mybatis
		System.out.println("updateform 작업할 차례");
		return "pur_updateform";
	}
}
