package com.mycompany.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.PurSearchDTO;
import com.mycompany.domain.PurposalDTO;
import com.mycompany.domain.SampSearchDTO;
import com.mycompany.domain.SampleDTO;
import com.mycompany.persistence.PurposalDAO;
import com.mycompany.service.UploadService;
import com.mycompany.service.PurposalService;
import com.mycompany.service.SampleService;
import com.mycompany.service.UploadService;

@Controller
public class SampController {
	@Autowired
	PurposalService purService;
	@Autowired
	SampleService samservice;
	@Autowired
	UploadService upload;
	
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
	public String sample_writeform(Model model,HttpSession sess, @PathVariable("pdt_name") String pdt_name ) {
		
		//현재 로그인한 직원 번호를 세션에서 가져옴
		String writer = (String)sess.getAttribute("session");
		//비정상적인 경로로 update 페이지에 오면 session이 null
		if(writer == null) writer = "emp";
		model.addAttribute("writer", writer);
		
		PurposalDTO purDTO = new PurposalDTO();
		purDTO.setPdt_name(pdt_name);
		purDTO =  purService.purposalRead(purDTO);
		model.addAttribute("pur",purDTO);
		
		return "samp_writeform_step2";
	}
	
	@RequestMapping("samp_write")
	public String sample_write(SampleDTO samp,HttpSession sess, @RequestParam("file") MultipartFile file) {
		if(!file.isEmpty()) {
			// 업로드 위치 절대경로
			String realPath = sess.getServletContext().getRealPath("/");
			samp.setPic(upload.saveFile(file, realPath));
			samp.setOrgpic(file.getOriginalFilename());
		}
		
		samservice.sampleInsert(samp);
		
		return "redirect:/samp_list/1";
	}
	
	@RequestMapping(value="samp_list/{pageNum}")
	public String samp_list(Model model, Criteria cri) {
		int total = samservice.sampleCnt(); //
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<SampleDTO> list = samservice.sampleListPaging(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		model.addAttribute("sampsearch", SampSearchDTO.values());
		return "samp_list";
	}
	@RequestMapping(value="samp_list_search")
	public String samp_list_search(Model model, Criteria cri) {
		int total = samservice.sampleSearchCnt(cri); //
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<SampleDTO> list = samservice.sampleListPagingSearch(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		model.addAttribute("sampsearch", SampSearchDTO.values());
		return "samp_list";
	}
	@RequestMapping(value="samp_list/{pageNum}/{condi}/{keyword}")
	public String samp_list_search_pagemove(Model model, Criteria cri) {
		//검색 조건이 없을때 기본 목록으로 리다이렉트
		if(cri.getCondi().equals("#")) { 
			return "redirect:/samp_list/"+cri.getPageNum();
		}
		//키워드가 없을 때 공백으로 치환
		if(cri.getKeyword().equals("#")) {
			cri.setKeyword("");
		}
		int total = samservice.sampleSearchCnt(cri); //
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<SampleDTO> list = samservice.sampleListPagingSearch(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		model.addAttribute("sampsearch", SampSearchDTO.values());
		return "samp_list";
	}
	
	@RequestMapping(value="samp_read/{samp_id}/{pageNum}")
	public String samp_read(Model model,HttpSession sess, @PathVariable("samp_id") String samp_id, @PathVariable("pageNum") String pageNum) {
		
		//현재 로그인한 직원 번호를 세션에서 가져옴
		String writer = (String)sess.getAttribute("session");
		//비정상적인 경로로 update 페이지에 오면 session이 null
		if(writer == null) writer = "emp";
		model.addAttribute("writer", writer);
		
		//DB 처리 : mybatis
		SampleDTO dto = new SampleDTO();
		dto = samservice.sampleRead(samp_id);
		model.addAttribute("samp", dto);
		
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("imgPath", upload.getReadPath(dto.getPic(),dto.getIns_date()));
		return "samp_read";
	}
	
	@RequestMapping(value="samp_updateform")
	public String samp_updateform(Model model, @RequestParam("writer") String writer, @RequestParam("pageNum") String pageNum,SampleDTO samp) {
		//비정상적인 경로로 update 페이지에 오면 session이 null
		if(writer == null) writer = "editor";
		model.addAttribute("writer", writer);
		
		samp = samservice.sampleRead(samp.getSamp_id());
		model.addAttribute("samp",samp);
		model.addAttribute("pageNum",pageNum);
		
		return "samp_updateform";
	}
	
	@RequestMapping("samp_update")
	public String samp_update(@RequestParam("file") MultipartFile file,HttpSession sess,@RequestParam("pageNum")String pageNum, SampleDTO samp) {
		//pic은 변화 없음
		
		if(!file.isEmpty()) {
			samp.setOrgpic(file.getOriginalFilename());
			// 업로드 위치 절대경로
			String realPath = sess.getServletContext().getRealPath("/");
			upload.updateFile(file,realPath,samp.getPic(),samp.getIns_date());
		}
		samservice.sampleUpdate(samp);
		
		return "redirect:/samp_list/"+pageNum;
	}
}
