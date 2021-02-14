package com.mycompany.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.domain.AuthenticationCode;
import com.mycompany.domain.CocompanyDTO;
import com.mycompany.domain.Criteria;
import com.mycompany.domain.PageDTO;
import com.mycompany.domain.Pdt_typeDTO;
import com.mycompany.service.CocompanyService;

@Controller
public class CocompanyController {

	@Autowired
	private CocompanyService cocservice;
	
	AuthenticationCode auth_code = AuthenticationCode.getInstance();

	@RequestMapping("coc_writeform")
	public String coc_writeform(Model model) {

		// 유형,주고객 프론트로 전달.
		ArrayList<String> Pdt_type_list = new ArrayList<String>();

		for (Pdt_typeDTO Pdt_type : Pdt_typeDTO.values()) {
			Pdt_type_list.add(Pdt_type.getKey());
		}

		model.addAttribute("Pdt_type_list", Pdt_type_list);

		return "coc_writeform";
	}

	// 등록
	@RequestMapping(value = "coc_write", method = RequestMethod.POST)
	public String coc_write(CocompanyDTO dto, HttpServletResponse response) throws IOException {

		// DB 처리 : mybatis
		System.out.println(dto.toString());
		if(auth_code.check(dto.getEmpno())) {
			//유형 수 만큼 insert 반복
			String[] types = dto.getPdt_type().split(",");
//			List<CocompanyDTO> coc_list = cocservice.cocompanyRead(dto.getCoc_name());
//			List<String> db_types = new ArrayList<>();
//			for(CocompanyDTO coc : coc_list) {
//				db_types.add(coc.getPdt_type());
//			}
//			for(int i = 0; i<types.length; i++) {
//				if(db_types.contains(types[i])) {
//					response.setContentType("text/html; charset=UTF-8");			 
//					PrintWriter out = response.getWriter();		 
//					out.println("<script>alert('중복된 유형이 있습니다.'); location.href='coc_writeform';</script>");
//					 
//					out.flush();
//					out.close();
//				}
//			}
			for(int i = 0; i<types.length; i++) {
				dto.setPdt_type(types[i]);
				cocservice.cocompanyInsert(dto);
			}
		}
		else {
			response.setContentType("text/html; charset=UTF-8");			 
			PrintWriter out = response.getWriter();		 
			out.println("<script>alert('인증코드가 올바르지 않습니다.'); location.href='coc_writeform';</script>");
			 
			out.flush();
			out.close();
		}

		return "redirect:/coc_list/1";
	}
	
	@RequestMapping(value="coc_list/{pageNum}")
	public String coc_list(Model model, Criteria cri) {
		int total = cocservice.cocompanyCnt();
		
		//cri.pageNum==1, cri.amout == 10; (default)
		List<CocompanyDTO> list = cocservice.cocompanyListPaging(cri);
		
		model.addAttribute("page",new PageDTO(cri, total));
		model.addAttribute("list", list);
		
		return "coc_list";
	}
	
	@RequestMapping(value="coc_read/{coc_name}/{pageNum}")
	public String coc_read(Model model, @PathVariable("coc_name") String coc_name, @PathVariable("pageNum") String pageNum) {
		
		//DB 처리 : mybatis
		CocompanyDTO dto = new CocompanyDTO();
		dto.setCoc_name(coc_name);
		List<CocompanyDTO> list = cocservice.cocompanyRead(dto.getCoc_name());
		if(!list.isEmpty()) {
			model.addAttribute("coc", list.get(0));
		}
		model.addAttribute("list", list);
		model.addAttribute("pageNum",pageNum);
		
		System.out.println(dto.toString());
		return "coc_read";
	}
	
	@RequestMapping(value="coc_updateform")
	public String coc_updateform(Model model, String coc_name, String pageNum) {
		
		CocompanyDTO dto = new CocompanyDTO();
		dto.setCoc_name(coc_name);
		List<CocompanyDTO> list = cocservice.cocompanyRead(dto.getCoc_name());
		if(!list.isEmpty()) {
			model.addAttribute("coc", list.get(0));
			model.addAttribute("pwd", list.get(0).getPwd());
		}
		
		model.addAttribute("pageNum",pageNum);
		
		
		return "coc_updateform";
	}
	@RequestMapping(value="coc_update")
	public String coc_update(CocompanyDTO dto, String pageNum) throws IOException {
		
		cocservice.cocompanyUpdate(dto);
		return "redirect:/coc_list/"+pageNum;
	}
	
	@RequestMapping(value="/coc_dupli")
	@ResponseBody
	public String coc_duplicate( String coc_name, @RequestParam(value="checked_array[]") ArrayList<String> checked_array) {
		List<CocompanyDTO> coc_list = cocservice.cocompanyRead(coc_name);
		ArrayList<String> db_types = new ArrayList<String>();
		for(CocompanyDTO coc : coc_list) {
			db_types.add(coc.getPdt_type());
			System.out.print(coc.getPdt_type()+" ");
		}
		if(checked_array.isEmpty()) {
			return "0";
		}
		System.out.println();
		System.out.println("checked_array.size(): " + checked_array.size());
		for(int i = 0; i<checked_array.size(); i++) {
			System.out.print(checked_array.get(i)+" ");
			if(db_types.contains(checked_array.get(i))) {
				return "-1";
			}
		}
		
		return "1";
	}
	
	@RequestMapping(value="/coc_pwd_check")
	@ResponseBody
	public String coc_pwd_check( String coc_name, String pwd_check) {
		List<CocompanyDTO> list = cocservice.cocompanyRead(coc_name);
		String pwd = list.get(0).getPwd();
		if(!pwd.equals(pwd_check)) {
			return "-1";
		}
		else
			return "1";
	}
}
