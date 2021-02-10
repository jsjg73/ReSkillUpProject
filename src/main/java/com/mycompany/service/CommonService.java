package com.mycompany.service;

import java.io.File;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
	String saveFiles(MultipartFile file, Date date);
	
}
