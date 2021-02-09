package com.mycompany.controller;

import java.util.ArrayList;
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
import com.mycompany.domain.Pdt_typeDTO;
import com.mycompany.domain.PurposalDTO;
import com.mycompany.domain.TargetDTO;
import com.mycompany.persistence.PurposalDAO;
import com.mycompany.service.PurposalService;

@Controller
public class PurposalController {

	@Autowired
	PurposalDAO dao ;
	@Autowired
	PurposalService service;
	
	
	@RequestMapping("pur_writeform")
	public String pur_writeform(Model model) {
		ArrayList<String> Pdt_type_list = new ArrayList<String>();

		for (Pdt_typeDTO Pdt_type : Pdt_typeDTO.values()) {
			Pdt_type_list.add(Pdt_type.getKey());
		}
		
		ArrayList<String> TargetDTO_list = new ArrayList<String>();

		for (TargetDTO TargetDTO : TargetDTO.values()) {
			TargetDTO_list.add(TargetDTO.getKey());
		}
		System.out.println("Pdt_type_list size : " + Pdt_type_list.size());
		System.out.println("TargetDTO_list size : " + TargetDTO_list.size());
		System.out.println("한글 확인 : " + Pdt_type_list.get(0));
		model.addAttribute("Pdt_type_list", Pdt_type_list);
		model.addAttribute("TargetDTO_list", TargetDTO_list);
		
		return "pur_writeform";
	}
	
	
	@RequestMapping(value="pur_write", method=RequestMethod.POST)
	public String pur_write(PurposalDTO dto, HttpSession sess) {
		
		//DB 처리 : mybatis
		dto.setWriter((String)sess.getAttribute("session"));
		System.out.println(dto.toString());
		service.PurposalInsert(dto);
		
		return "redirect:/pur_list/1";
	}
	
	@RequestMapping(value="pur_list/{pageNum}")
	public String pur_list(Model model, Criteria cri) {
		int total = service.purposalCnt();
		
		//DB 처리 : mybatis
		System.out.println(cri);
		List<PurposalDTO> list = dao.purposalListPaging(cri);
		//list null  문제
		System.out.println(list.size());
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
		
		// taget 체크박스 체크
		String[] targets = dto.getTarget().split(",");
		model.addAttribute("targets",targets);
		
		return "pur_read";
	}
	@RequestMapping(value="pur_updateform")
	public String pur_updateform(Model model, String pdt_name, HttpSession sess) {
		
		
		model.addAttribute("editor", (String)sess.getAttribute("session"));
//		model.addAttribute("editor", editor);
		
		PurposalDTO dto = new PurposalDTO();
		dto.setPdt_name(pdt_name);
		dto = dao.purposalRead(dto);
		model.addAttribute("dto",dto);
		
		// taget 체크박스 체크
		String[] targets = dto.getTarget().split(",");
		model.addAttribute("targets",targets);
		return "pur_updateform";
	}
	@RequestMapping(value="pur_update")
	public String pur_update(Model model, PurposalDTO dto) {
		
		//DB 처리 : mybatis
		System.out.println("update 작업할 차례");
		System.out.println(dto);
		service.purposalUpdate(dto);
		return "redirect:/pur_list/1";
	}
}
