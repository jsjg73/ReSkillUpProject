package com.mycompany.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CocompanyDTO {
	private String coc_name;
	private Pdt_typeDTO pdt_type;
	private String pwd;
	private int empno;
	private String coc_emp;
	private String coc_call;
	private String coc_mail;
	@Override
	public String toString() {
		return "CocompanyDTO [coc_name=" + coc_name + ", pdt_type=" + pdt_type + ", pwd=" + pwd + ", empno=" + empno
				+ ", coc_emp=" + coc_emp + ", coc_call=" + coc_call + ", coc_mail=" + coc_mail + "]";
	}
	
	
}
