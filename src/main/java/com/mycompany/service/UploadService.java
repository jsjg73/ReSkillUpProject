package com.mycompany.service;

import java.io.File;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	String saveFile(MultipartFile file, String realPath);
	void updateFile(MultipartFile file, String realPath, String pic, Date date);
	String getReadPath(String filename ,Date date);
}
