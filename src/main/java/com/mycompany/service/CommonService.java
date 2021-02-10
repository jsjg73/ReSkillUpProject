package com.mycompany.service;

import java.io.File;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
	String saveFile(MultipartFile file, Date date,String realPath);
	String getReadPath(String filename ,Date date);
}
