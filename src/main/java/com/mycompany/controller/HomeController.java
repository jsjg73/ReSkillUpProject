package com.mycompany.controller;

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
import com.mycompany.domain.PurposalDTO;
import com.mycompany.persistence.PurposalDAO;
import com.mycompany.service.PurposalService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	PurposalDAO dao ;
	@Autowired
	PurposalService service;
	
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
	public String pur_write(PurposalDTO dto, HttpSession sess) {
		
		//DB 처리 : mybatis
		dto.setWriter((String)sess.getAttribute("login"));
		dao.PurposalInsert(dto);
		
		return "redirect:/pur_list";
	}
	
	@RequestMapping(value="pur_list/{pageNum}")
	public String pur_list(Model model, Criteria cri) {
		int total = service.puposalCnt();
		
		//DB 처리 : mybatis
		List<PurposalDTO> list = dao.purposalListPaging(cri);
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		
		return "pur_list";
	}
	
	@RequestMapping(value="pur_read/{pdt_name}")
	public String pur_read(Model model, @PathVariable("pdt_name") String pdt_name) {
		
		//DB 처리 : mybatis
		PurposalDTO dto = new PurposalDTO();
		dto.setPdt_name(pdt_name);
		dto = dao.purposalRead(dto);
		model.addAttribute("pur", dto);
		return "pur_read";
	}
	@RequestMapping(value="pur_updateform")
	public String pur_updateform(Model model, PurposalDTO dto, HttpSession sess) {
		
		//DB 처리 : mybatis
		dto.setWriter((String)sess.getAttribute("login"));
		model.addAttribute("dto",dto);
		return "pur_updateform";
	}
	@RequestMapping(value="pur_update")
	public String pur_update(Model model, PurposalDTO dto) {
		
		//DB 처리 : mybatis
		System.out.println("update 작업할 차례");
		
		return "pur_read";
	}
}
