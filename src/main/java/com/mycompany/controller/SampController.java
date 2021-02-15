package com.mycompany.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.PurSearchDTO;
import com.mycompany.domain.PurposalDTO;
import com.mycompany.domain.SampSearchDTO;
import com.mycompany.domain.SampleDTO;
import com.mycompany.service.UploadService;
import com.mycompany.service.CocompanyService;
import com.mycompany.service.PurposalService;
import com.mycompany.service.SampleService;
import com.mycompany.service.UploadService;

@RequestMapping("/samp")
@Controller
public class SampController {
	@Autowired
	PurposalService purService;
	@Autowired
	SampleService samservice;
	@Autowired
	CocompanyService cocservice;
	@Autowired
	UploadService upload;
	
	@RequestMapping("writeform_step1/{pageNum}")
	public String sample_writeform_step1(Model model, Criteria cri) {
		int total = purService.purposalCnt();
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<PurposalDTO> list = purService.purposalListPaging(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		model.addAttribute("pursearch", PurSearchDTO.values());//검색조건 enum
		return "samp_writeform_step1";
	}
	//기획서 목록 키워드 검색
	@RequestMapping("writeform_step1/search")
	public String samp_search_writeform_step1(Model model, Criteria cri) {
		int total = purService.purposalSearchCnt(cri);
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<PurposalDTO> list = purService.purposalListPagingSearch(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		model.addAttribute("pursearch", PurSearchDTO.values());//검색조건 enum
		
		return "samp_writeform_step1";
	}
	//검색된 제품 목록 페이지 이동
	@RequestMapping("writeform_step1/{pageNum}/{condi}/{keyword}")
	public String samp_search_writeform_step1_pagemove(Model model, Criteria cri) {
		//검색 조건이 없을때 기본 목록으로 리다이렉트
		if(cri.getCondi().equals("#")) { 
			return "redirect:/samp/writeform_step1/"+cri.getPageNum();
		}
		//키워드가 없을 때 공백으로 치환
		if(cri.getKeyword().equals("#")) {
			cri.setKeyword("");
		}
		int total = purService.purposalSearchCnt(cri);
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<PurposalDTO> list = purService.purposalListPagingSearch(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		model.addAttribute("pursearch", PurSearchDTO.values());//검색조건 enum
		
		return "samp_writeform_step1";
	}
	
	@RequestMapping("writeform/{pdt_name}")
	public String sample_writeform(Model model,HttpSession sess, @PathVariable("pdt_name") String pdt_name, HttpServletRequest req) {
		
		PurposalDTO purDTO = new PurposalDTO();
		purDTO.setPdt_name(pdt_name);
		purDTO =  purService.purposalRead(purDTO);
		List<String> coc_name_list = cocservice.cocompanyReadByPdt_type(purDTO.getPdt_type().getKey());
		model.addAttribute("pur",purDTO);
		model.addAttribute("coc_name_list",coc_name_list);
//		model.addAttribute("writer", req.getAttribute("writer"));
		return "samp_writeform_step2";
	}
	
	@RequestMapping("write")
	public String sample_write(SampleDTO samp,HttpSession sess, @RequestParam("file") MultipartFile file) {
		if(!file.isEmpty()) {
			// 업로드 위치 절대경로
			String realPath = sess.getServletContext().getRealPath("/");
			samp.setPic(upload.saveFile(file, realPath));
			samp.setOrgpic(file.getOriginalFilename());
		}
		
		samservice.sampleInsert(samp);
		
		return "redirect:/samp/list/1";
	}
	
	@RequestMapping(value="list/{pageNum}")
	public String samp_list(Model model, Criteria cri) {
		int total = samservice.sampleCnt(); //
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<SampleDTO> list = samservice.sampleListPaging(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		model.addAttribute("sampsearch", SampSearchDTO.values());//검색조건 enum
		return "samp_list";
	}
	@RequestMapping(value="list_search")
	public String samp_list_search(Model model, Criteria cri) {
		int total = samservice.sampleSearchCnt(cri); //
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<SampleDTO> list = samservice.sampleListPagingSearch(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		model.addAttribute("sampsearch", SampSearchDTO.values());//검색조건 enum
		return "samp_list";
	}
	@RequestMapping(value="list/{pageNum}/{condi}/{keyword}")
	public String samp_list_search_pagemove(Model model, Criteria cri) {
		//검색 조건이 없을때 기본 목록으로 리다이렉트
		if(cri.getCondi().equals("#")) { 
			return "redirect:/samp/list/"+cri.getPageNum();
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
		model.addAttribute("sampsearch", SampSearchDTO.values());//검색조건 enum
		return "samp_list";
	}
	
	@RequestMapping(value="read/{samp_id}/{pageNum}")
	public String samp_read(Model model,HttpSession sess, @PathVariable("samp_id") String samp_id, @PathVariable("pageNum") String pageNum) {
		
		//DB 처리 : mybatis
		SampleDTO dto = new SampleDTO();
		dto = samservice.sampleRead(samp_id);
		model.addAttribute("samp", dto);
		
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("imgPath", upload.getReadPath(dto.getPic(),dto.getIns_date()));
		return "samp_read";
	}
	
	@RequestMapping(value="updateform")
	public String samp_updateform(Model model, @RequestParam("pageNum") String pageNum,SampleDTO samp, HttpServletRequest req) {
		
		samp = samservice.sampleRead(samp.getSamp_id());
		model.addAttribute("samp",samp);
		model.addAttribute("pageNum",pageNum);
//		model.addAttribute("writer", req.getAttribute("writer"));
		return "samp_updateform";
	}
	
	@RequestMapping("update")
	public String samp_update(@RequestParam("file") MultipartFile file,HttpSession sess,@RequestParam("pageNum")String pageNum, SampleDTO samp) {
		//pic은 변화 없음
		System.out.println(samp.getPic());
		if(!file.isEmpty()) {
			samp.setOrgpic(file.getOriginalFilename());
			// 업로드 위치 절대경로
			String realPath = sess.getServletContext().getRealPath("/");
			if(samp.getPic().equals("")) { // 사진 처음 등록
				samp.setPic(upload.saveFile(file,realPath,samp.getIns_date()));
			}else {
				upload.updateFile(file,realPath,samp.getPic(),samp.getIns_date());
			}
		}
		samservice.sampleUpdate(samp);
		
		return "redirect:/samp/list/"+pageNum;
	}
	
	@RequestMapping(value="/dupli")
	@ResponseBody
	public String samp_duplicate( String samp_id) {
		SampleDTO samp = samservice.sampleRead(samp_id);
		if(samp==null)
			return "-1";
		else 
			return "1";
	}
}
