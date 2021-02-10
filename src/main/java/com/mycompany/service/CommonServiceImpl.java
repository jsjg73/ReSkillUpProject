package com.mycompany.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonServiceImpl implements CommonService {

	@Override
	public String saveFiles(MultipartFile file, Date date) {
		File uploadPath = new File("C:\\upload\\tmp",getFolder(date));
		
		if(uploadPath.exists()==false)
			uploadPath.mkdirs();
		//make yyyy/MM/dd folder
		UUID uuid = UUID.randomUUID();
		
		String saveName = uuid.toString()+"_"+ file.getOriginalFilename();
	    // 저장할 File 객체를 생성(껍데기 파일)
	    File saveFile = new File(uploadPath,saveName); // 저장할 폴더 이름, 저장할 파일 이름

	    try {
	        file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

		return saveName;
	}
	
	
	private String getFolder(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
}
