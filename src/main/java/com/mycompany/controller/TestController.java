package com.mycompany.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/test/*")
@Log4j
public class TestController {
	
	@RequestMapping(value="/getText",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getText(HttpServletResponse res) {
		log.info("MIME TYPE "+ MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
}
