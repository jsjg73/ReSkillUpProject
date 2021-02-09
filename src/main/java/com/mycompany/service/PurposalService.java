package com.mycompany.service;

import org.springframework.web.multipart.MultipartFile;

import com.mycompany.domain.PurposalDTO;

public interface PurposalService {

	int purposalCnt();
	public void PurposalInsert(PurposalDTO dto);
	void purposalUpdate(PurposalDTO dto);
	public String saveFile(MultipartFile file);
}
