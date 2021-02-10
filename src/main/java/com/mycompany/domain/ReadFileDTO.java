package com.mycompany.domain;

import lombok.Data;

@Data
public class ReadFileDTO {
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
}
