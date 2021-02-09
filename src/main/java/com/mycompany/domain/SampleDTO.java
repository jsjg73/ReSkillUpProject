package com.mycompany.domain;

import java.sql.Date;

import lombok.Data;
@Data
public class SampleDTO {
	private String samp_id;
	private Date arriv_date;
	private String writer;
	private int price;
	private String bigo;
	private String pic;
	private String orgpic;
	private Date ins_date;
	private Date upd_date;
	private String coc_name;
	private String pdt_name;
	private Pdt_typeDTO pdt_type;

	
	
}
