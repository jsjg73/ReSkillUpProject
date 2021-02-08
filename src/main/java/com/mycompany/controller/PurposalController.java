package com.mycompany.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.PurposalDTO;
import com.mycompany.persistence.PurposalDAO;
import com.mycompany.service.PurposalService;

@Controller
public class PurposalController {

	@Autowired
	PurposalDAO dao ;
	@Autowired
	PurposalService service;
	
	
	@RequestMapping("pur_writeform")
	public String pur_writeform() {
		return "pur_writeform";
	}
	
	//등록
	@RequestMapping(value="pur_write", method=RequestMethod.POST)
	public String pur_write(PurposalDTO dto, HttpSession sess) {
		
		//등록
		dao.PurposalInsert(dto);
		
		return "redirect:/pur_list/1";
	}
	
	//
	@RequestMapping(value="pur_list/{pageNum}")
	public String pur_list(Model model, Criteria cri) {
		int total = service.purposalCnt();
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<PurposalDTO> list = dao.purposalListPaging(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		
		return "pur_list";
	}
	
	@RequestMapping(value="pur_read/{pdt_name}/{pageNum}")
	public String pur_read(Model model, @PathVariable("pdt_name") String pdt_name, @PathVariable("pageNum") String pageNum) {
		
		//DB 처리 : mybatis
		PurposalDTO dto = new PurposalDTO();
		dto.setPdt_name(pdt_name);
		dto = dao.purposalRead(dto);
		model.addAttribute("pur", dto);
		
		// taget 체크박스 체크
		String[] targets = dto.getTarget().split(",");
		model.addAttribute("targets",targets);
		model.addAttribute("pageNum",pageNum);
		
		return "pur_read";
	}
	@RequestMapping(value="pur_updateform")
	public String pur_updateform(Model model, String pdt_name, HttpSession sess, String pageNum) {
		
		String editor = (String)sess.getAttribute("session");
		if(editor == null) editor = "editor";
		model.addAttribute("editor", editor);
		
		PurposalDTO dto = new PurposalDTO();
		dto.setPdt_name(pdt_name);
		dto = dao.purposalRead(dto);
		model.addAttribute("dto",dto);
		
		// taget 체크박스 체크
		String[] targets = dto.getTarget().split(",");
		model.addAttribute("targets",targets);
		model.addAttribute("pageNum",pageNum);
		return "pur_updateform";
	}
	@RequestMapping(value="pur_update")
	public String pur_update(Model model, PurposalDTO dto, String pageNum) {
		
		service.purposalUpdate(dto);
		return "redirect:/pur_list/"+pageNum;
	}
}
