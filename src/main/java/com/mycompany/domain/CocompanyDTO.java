package com.mycompany.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CocompanyDTO {
	private String coc_name;
	private String pdt_type;
	private String pwd;
	private int empno;
	private String coc_emp;
	private String coc_call;
	private String coc_mail;
	
}
