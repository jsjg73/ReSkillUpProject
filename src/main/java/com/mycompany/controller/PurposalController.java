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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.Pdt_typeDTO;
import com.mycompany.domain.PurposalDTO;

import com.mycompany.domain.TargetDTO;
import com.mycompany.service.CommonService;
import com.mycompany.service.PurposalService;
import com.mycompany.service.UploadService;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j
public class PurposalController {

	@Autowired
	PurposalService service;
	@Autowired
	CommonService commonservice;
	@Autowired
	UploadService upload;
	
	@RequestMapping("pur_writeform")
	public String pur_writeform(Model model) {
		
		//유형,주고객 프론트로 전달.
		ArrayList<String> Pdt_type_list = new ArrayList<String>();
		ArrayList<String> TargetDTO_list = new ArrayList<String>();

		for (Pdt_typeDTO Pdt_type : Pdt_typeDTO.values()) {
			Pdt_type_list.add(Pdt_type.getKey());
		}
		for (TargetDTO TargetDTO : TargetDTO.values()) {
			TargetDTO_list.add(TargetDTO.getKey());
		}
		model.addAttribute("Pdt_type_list", Pdt_type_list);
		model.addAttribute("TargetDTO_list", TargetDTO_list);
		
		return "pur_writeform";
	}
	

	//등록
	@RequestMapping(value="pur_write", method=RequestMethod.POST)
	public String pur_write(@RequestParam("file") MultipartFile file, PurposalDTO dto,  HttpSession sess) {
		
		//DB 처리 : mybatis

		dto.setWriter((String)sess.getAttribute("session"));
		dto.setOrgpic(file.getOriginalFilename());
		dto.setPic(upload.saveFile(file));
		System.out.println(dto.toString());
		
		service.PurposalInsert(dto);
		
		return "redirect:/pur_list/1";
	}
	
	//
	@RequestMapping(value="pur_list/{pageNum}")
	public String pur_list(Model model, Criteria cri) {
		int total = service.purposalCnt();
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<PurposalDTO> list = service.purposalListPaging(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		
		return "pur_list";
	}
	
	@RequestMapping(value="pur_read/{pdt_name}/{pageNum}")
	public String pur_read(Model model, @PathVariable("pdt_name") String pdt_name, @PathVariable("pageNum") String pageNum) {
		
		//DB 처리 : mybatis
		PurposalDTO dto = new PurposalDTO();
		dto.setPdt_name(pdt_name);
		dto = service.purposalRead(dto);
		model.addAttribute("pur", dto);
		
		// taget 체크박스 체크
		String[] targets = dto.getTarget().split(",");
		model.addAttribute("targets",targets);
		model.addAttribute("pageNum",pageNum);
		upload.getFilePath(dto);
		
		return "pur_read";
	}
	@RequestMapping(value="pur_updateform")
	public String pur_updateform(Model model, String pdt_name, HttpSession sess, String pageNum) {
		
		//현재 로그인한 직원 번호를 세션에서 가져옴
		String editor = (String)sess.getAttribute("session");
		//비정상적인 경로로 update 페이지에 오면 session이 null
		if(editor == null) editor = "editor";
		model.addAttribute("editor", editor);
		
		PurposalDTO dto = new PurposalDTO();
		dto.setPdt_name(pdt_name);
		dto = service.purposalRead(dto);
		model.addAttribute("dto",dto);
		
		// taget 체크박스 체크
		String[] targets = dto.getTarget().split(",");
		for(String str : targets) {
			System.out.print(str + " ");
		}
		model.addAttribute("targets",targets);
		model.addAttribute("pageNum",pageNum);
		
		//checkbox form만들기
		ArrayList<String> TargetDTO_list = new ArrayList<String>();
		for (TargetDTO TargetDTO : TargetDTO.values()) {
			TargetDTO_list.add(TargetDTO.getKey());
		}
		model.addAttribute("TargetDTO_list", TargetDTO_list);
		return "pur_updateform";
	}
	@RequestMapping(value="pur_update")
	public String pur_update(Model model, PurposalDTO dto, String pageNum) {
		
		service.purposalUpdate(dto);
		return "redirect:/pur_list/"+pageNum;
	}
}
