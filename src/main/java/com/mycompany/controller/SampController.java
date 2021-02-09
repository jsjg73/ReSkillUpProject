package com.mycompany.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.PurposalDTO;
import com.mycompany.domain.SampleDTO;
import com.mycompany.persistence.PurposalDAO;
import com.mycompany.service.PurposalService;
import com.mycompany.service.SampleService;

@Controller
public class SampController {
	@Autowired
	PurposalService purService;
	
	@Autowired
	SampleService samservice;
	
	@RequestMapping("samp_writeform_step1")
	public String sample_writeform_step1(Model model, Criteria cri) {
		int total = purService.purposalCnt();
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<PurposalDTO> list = purService.purposalListPaging(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		
		return "samp_writeform_step1";
	}
	
	@RequestMapping("samp_writeform/{pdt_name}")
	public String sample_writeform(Model model,HttpSession sess, @PathVariable("pdt_name") String pdt_name, @PathVariable("pageNum") String pageNum ) {
		
		//현재 로그인한 직원 번호를 세션에서 가져옴
		String writer = (String)sess.getAttribute("session");
		//비정상적인 경로로 update 페이지에 오면 session이 null
		if(writer == null) writer = "emp";
		model.addAttribute("writer", writer);
		
		PurposalDTO purDTO = new PurposalDTO();
		purDTO.setPdt_name(pdt_name);
		purDTO =  purService.purposalRead(purDTO);
		model.addAttribute("pur",purDTO);
		
		
		model.addAttribute("pageNum",pageNum);
		
		
		return "samp_writeform_step2";
	}
	
	@RequestMapping("samp_write")
	public String sample_write(SampleDTO samp) {
		System.out.println(samp);
		samservice.sampleInsert(samp);
		
		return "redirect:/samp_list/1";
	}
}
