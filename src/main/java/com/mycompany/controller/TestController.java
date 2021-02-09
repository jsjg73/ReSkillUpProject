package com.mycompany.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.domain.SampleVO;

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
	
	@RequestMapping(value = "/getSample")
	@ResponseBody
	public SampleVO getSample() {
		return new SampleVO(112,"스타","로드");
	}
	
	@RequestMapping(value = "/getList")
	@ResponseBody
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		for (int i = 0; i < 10; i++) {
			list.add(new SampleVO(i, i+"First", i+" Last"));
		}
		return list;
	}
	@RequestMapping(value = "/getMap")
	@ResponseBody
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		return map;
	}
}
