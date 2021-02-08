package com.mycompany.domain;

import java.sql.Date;

public class PurposalDTO {
	private Date reg_date;
	private Date ins_date;
	private Date upd_date;
	private String writer;
	private String pdt_name;
	
	private int pdt_type;
	
	private String bigo;
	private String target;
	private String pic;
	private String orgpic;
	private Pdt_typeDTO pdt_typeDTO;
	private TargetDTO targetDTO;
	
	public TargetDTO getTargetDTO() {
		return targetDTO;
	}
	public void setTargetDTO(TargetDTO targetDTO) {
		this.targetDTO = targetDTO;
	}
	public Pdt_typeDTO getPdt_typeDTO() {
		return pdt_typeDTO;
	}
	public void setPdt_typeDTO(Pdt_typeDTO pdt_typeDTO) {
		this.pdt_typeDTO = pdt_typeDTO;
	}
	public String getOrgpic() {
		return orgpic;
	}
	public void setOrgpic(String orgpic) {
		this.orgpic = orgpic;
	}
	private int del_ck;
	
	public int getDel_ck() {
		return del_ck;
	}
	public void setDel_ck(int del_ck) {
		this.del_ck = del_ck;
	}
	
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getIns_date() {
		return ins_date;
	}
	public void setIns_date(Date ins_date) {
		this.ins_date = ins_date;
	}
	public Date getUpd_date() {
		return upd_date;
	}
	public void setUpd_date(Date upd_date) {
		this.upd_date = upd_date;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPdt_name() {
		return pdt_name;
	}
	public void setPdt_name(String pdt_name) {
		this.pdt_name = pdt_name;
	}
	public int getPdt_type() {
		return pdt_type;
	}
	public void setPdt_type(int pdt_type) {
		this.pdt_type = pdt_type;
	}
	public String getBigo() {
		return bigo;
	}
	public void setBigo(String bigo) {
		this.bigo = bigo;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
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