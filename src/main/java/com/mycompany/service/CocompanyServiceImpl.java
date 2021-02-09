package com.mycompany.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.domain.CocompanyDTO;
import com.mycompany.domain.Criteria;
import com.mycompany.persistence.CocompanyDAO;

public class CocompanyServiceImpl implements CocompanyService {
	@Autowired 
	public CocompanyDAO cocDAO;
	
	@Override
	public int cocompanyCnt() {
		return cocDAO.cocompanyCnt();
	}

	@Override
	public void cocompanyInsert(CocompanyDTO dto) {
		cocDAO.cocompanyInsert(dto);
	}

	@Override
	public void cocompanyUpdate(CocompanyDTO dto) {
		cocDAO.cocompanyUpdate(dto);
	}

	@Override
	public List<CocompanyDTO> cocompanyList() {		
		return cocDAO.cocompanyList();
	}

	@Override
	public List<CocompanyDTO> cocompanyListPaging(Criteria cri) {
		return cocDAO.cocompanyListPaging(cri);
	}

	@Override
	public CocompanyDTO cocompanyRead(CocompanyDTO dto) {
		return cocDAO.cocompanyRead(dto);
	}

	@Override
	public String saveFile(MultipartFile file){
	    
	    String saveName = file.getOriginalFilename();

	    // 저장할 File 객체를 생성(껍데기 파일)
	    File saveFile = new File("C:\\upload\\tmp",saveName); // 저장할 폴더 이름, 저장할 파일 이름

	    try {
	        file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return saveName;
	} 

}
