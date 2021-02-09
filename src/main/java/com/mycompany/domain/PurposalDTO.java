package com.mycompany.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
public class PurposalDTO {
	private Date reg_date;
	private Date ins_date;
	private Date upd_date;
	private String writer;
	private String pdt_name;
	private Pdt_typeDTO pdt_type;

	
	private String bigo;
	private String target;
	private String pic;
	private String orgpic;
	private int del_ck;
	
	
	@Override
	public String toString() {
		return "PurposalDTO [reg_date=" + reg_date + ", ins_date=" + ins_date + ", upd_date=" + upd_date + ", writer="
				+ writer + ", pdt_name=" + pdt_name + ", pdt_type=" + pdt_type + ", bigo=" + bigo + ", target=" + target
				+ ", pic=" + pic + ", orgpic=" + orgpic + ", del_ck=" + del_ck + "]";
	}
	
	
}

//create table purposal(
//pur_id number ,
//reg_date date not null,
//ins_date date not null,
//upd_date date not null,
//writer varchar2(20) not null,
//pdt_name varchar2(10) not null,
//pdt_type number not null,
//bigo varchar2(1000),
//target number not null,
//pic varchar2(100),
//constraints pk_purposal primary key(pur_id)
//);