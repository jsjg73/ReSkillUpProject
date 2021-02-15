package com.mycompany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.Pdt_typeDTO;
import com.mycompany.domain.PurSearchDTO;
import com.mycompany.domain.PurposalDTO;

import com.mycompany.domain.TargetDTO;
import com.mycompany.service.UploadService;
import com.mycompany.service.PurposalService;
import com.mycompany.service.UploadService;

@RequestMapping("/pur")
@Controller
public class PurposalController {

	@Autowired
	PurposalService service;
	@Autowired
	UploadService upload;
	
	@RequestMapping("writeform")
	public String pur_writeform(Model model, HttpServletRequest req) {
		
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
		
		/*from 인터셉터*/
		model.addAttribute("writer", req.getAttribute("writer"));
		
		return "pur_writeform";
	}
	

	//등록
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String pur_write(@RequestParam("file") MultipartFile file, PurposalDTO dto,  HttpSession sess, HttpServletRequest res) {
		
		//DB 처리 : mybatis
		if(!file.isEmpty()) {
			dto.setOrgpic(file.getOriginalFilename());
			// 업로드 위치 절대경로
			String realPath = sess.getServletContext().getRealPath("/");
			dto.setPic(upload.saveFile(file,realPath));
		}
		
		service.PurposalInsert(dto);
		
		return "redirect:/pur/list/1";
	}
	
	//기본 목록 조회
	@RequestMapping(value="/list/{pageNum}")
	public String pur_list(Model model, Criteria cri, HttpServletRequest req, HttpSession sess) {
		List<PurposalDTO> list =null;
		int total= 0;
		String login = (String)sess.getAttribute("login"); //로그인 형태  : 직원 or 제조사
		String coc_name =(String)req.getAttribute("coc_name"); 
		
		//제조사 로그인
		if(login.equals("coc") ) {
			if(coc_name != null) {
				total = service.cocPurposalCnt(coc_name);
				cri.setCoc_name(coc_name);
				//유형에 맞는 기획서 리스트
				list = service.cocPurposalListPaging(cri);
			}
			else
				System.out.println("제조사명 없으므로 진행 불가 에러");
		
		//직원 로그인
		}else {
			total = service.purposalCnt();
			//cri.pageNum==1, cri.amout == 10; (default)
			list = service.purposalListPaging(cri);
		}
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		model.addAttribute("pursearch", PurSearchDTO.values());//검색조건 enum
		return "pur_list";
	}
	
	//첫 검색어 목록 조회
	@RequestMapping(value="/list_search")
	public String pur_list_search(Model model, Criteria cri,HttpServletRequest req, HttpSession sess) {
		List<PurposalDTO> list =null;
		int total= 0;
		String login = (String)sess.getAttribute("login"); //로그인 형태  : 직원 or 제조사
		String coc_name =(String)req.getAttribute("coc_name"); 
		
		//제조사 로그인
		if(login.equals("coc") ) {
			if(coc_name != null) {
				cri.setCoc_name(coc_name);
				total = service.cocPurposalSearchCnt(cri);
				//유형에 맞는 기획서 리스트
				list = service.cocPurposalListPagingSearch(cri);
			}
			else
				System.out.println("제조사명 없으므로 진행 불가 에러");
		
		//직원 로그인
		}else {
			total = service.purposalSearchCnt(cri);
			
			//cri.pageNum==1, cri.amout == 10; (default)
			list = service.purposalListPagingSearch(cri);
		}
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		model.addAttribute("pursearch", PurSearchDTO.values()); //검색조건 enum
		return "pur_list";
	}
	
	//검색된 목록 페이지 이동
	@RequestMapping(value="/list/{pageNum}/{condi}/{keyword}")
	public String pur_list_search_pagemove(Model model, Criteria cri,HttpServletRequest req, HttpSession sess) {
		
		//검색 조건이 없을때 기본 목록으로 리다이렉트
		//cirteria 초기값 #
		if(cri.getCondi().equals("#")) { 
			return "redirect:/pur/list/"+cri.getPageNum();
		}
		//키워드가 없을 때 공백으로 치환
		if(cri.getKeyword().equals("#")) {
			cri.setKeyword("");
		}
		
		List<PurposalDTO> list =null;
		int total= 0;
		String login = (String)sess.getAttribute("login"); //로그인 형태  : 직원 or 제조사
		String coc_name =(String)req.getAttribute("coc_name"); 
		
		//제조사 로그인
		if(login.equals("coc") ) {
			if(coc_name != null) {
				cri.setCoc_name(coc_name);
				total = service.cocPurposalSearchCnt(cri);
				//유형에 맞는 기획서 리스트
				list = service.cocPurposalListPagingSearch(cri);
			}
			else
				System.out.println("제조사명 없으므로 진행 불가 에러");
		
		//직원 로그인
		}else {
			total = service.purposalSearchCnt(cri);
			
			//cri.pageNum==1, cri.amout == 10; (default)
			list = service.purposalListPagingSearch(cri);
		}
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		model.addAttribute("pursearch", PurSearchDTO.values());//검색조건 enum
		return "pur_list";
	}
	
	@RequestMapping(value="read/{pdt_name}/{pageNum}")
	public String pur_read(Model model, HttpSession sess, @PathVariable("pdt_name") String pdt_name, @PathVariable("pageNum") String pageNum) {
		
		//DB 처리 : mybatis
		PurposalDTO dto = new PurposalDTO();
		dto.setPdt_name(pdt_name);
		dto = service.purposalRead(dto);
		model.addAttribute("pur", dto);
		
		// taget 체크박스 체크
		String[] targets = dto.getTarget().split(",");
		model.addAttribute("targets",targets);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("imgPath", upload.getReadPath(dto.getPic(),dto.getIns_date()));
		
		return "pur_read";
	}
	@RequestMapping(value="updateform")
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
	@RequestMapping(value="update")
	public String pur_update( @RequestParam("file") MultipartFile file,HttpSession sess,Model model, PurposalDTO dto, String pageNum) {
		//pic은 변화 없음
		
		if(!file.isEmpty()) {
			dto.setOrgpic(file.getOriginalFilename());
			// 업로드 위치 절대경로
			String realPath = sess.getServletContext().getRealPath("/");
			upload.updateFile(file,realPath,dto.getPic(),dto.getIns_date());
		}
		service.purposalUpdate(dto);
		return "redirect:/pur/list/"+pageNum;
	}
	
	@RequestMapping(value="/dupli")
	@ResponseBody
	public String pur_duplicate( PurposalDTO pur) {
		pur = service.purposalRead(pur);
		if(pur==null)
			return "-1";
		else 
			return "1";
	}
}
