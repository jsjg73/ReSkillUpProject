package com.mycompany.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class UploadService {
	public String saveFile(MultipartFile file) {

		UUID uuid = UUID.randomUUID();
		String saveName = uuid + "_" + file.getOriginalFilename();

		// 저장할 File 객체를 생성(껍데기 파일)
		File saveFile = new File("C:\\upload\\tmp", saveName); // 저장할 폴더 이름, 저장할 파일 이름

		try {
			file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return saveName;
	}
}
