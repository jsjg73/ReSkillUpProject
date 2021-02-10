package com.mycompany.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.domain.ReadFileDTO;

@Controller
public class UploadController {
	
	@RequestMapping(value="/readPicAjaxAction", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReadFileDTO>> readPicAjaxPost() {
		return null;
	}
	
}//end
