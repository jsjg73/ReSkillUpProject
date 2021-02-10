package com.mycompany.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {

	@Override
	public String saveFile(MultipartFile file, String realPath ) {
		//실제 저장 위치
		File uploadPath = new File(realPath+"resources/upload/tmp",getFolder());
		
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
	@Override
	public String getReadPath(String filename ,Date date) {
		String str =null;
		str = getFolder()+"/"+filename;
		return str;
	}
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
}
