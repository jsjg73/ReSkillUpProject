package com.mycompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.PurposalDTO;
import com.mycompany.persistence.PurposalDAO;
import com.mycompany.service.PurposalService;

@Controller
public class SampController {
	@Autowired
	PurposalService purService;
	@Autowired
	PurposalDAO purDAO;
	@RequestMapping("/samp_writeform_step1")
	public String sample_writeform_step1(Model model, Criteria cri) {
		int total = purService.purposalCnt();
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<PurposalDTO> list = purDAO.purposalListPaging(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		
		return "samp_writeform_step1";
	}
	
	@RequestMapping("/samp_writeform/{pdt_name}/{pageNum}")
	public String sample_writeform(Model model, @PathVariable("pdt_name") String pdt_name, @PathVariable("pageNum") String pageNum ) {
		PurposalDTO purDTO = new PurposalDTO();
		purDTO.setPdt_name(pdt_name);
		purDTO =  purService.purposalRead(purDTO);
		
		model.addAttribute("pur",purDTO);
		model.addAttribute("pageNum",pageNum);
		return "samp_writeform_step2";
	}
}
