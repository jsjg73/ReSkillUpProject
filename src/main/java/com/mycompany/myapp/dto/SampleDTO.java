package com.mycompany.myapp.dto;

import java.sql.Date;

public class SampleDTO {
	private String samp_id;
	private Date arriv_date;
	private String writer;
	private int price;
	private String bigo;
	private String pic;
	private Date ins_date;
	private Date upd_date;
	private String coc_name;
	private String pdt_name;
	private int pdt_type;
	
	
	public String getSamp_id() {
		return samp_id;
	}
	public void setSamp_id(String samp_id) {
		this.samp_id = samp_id;
	}
	public Date getArriv_date() {
		return arriv_date;
	}
	public void setArriv_date(Date arriv_date) {
		this.arriv_date = arriv_date;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBigo() {
		return bigo;
	}
	public void setBigo(String bigo) {
		this.bigo = bigo;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
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
	public String getCoc_name() {
		return coc_name;
	}
	public void setCoc_name(String coc_name) {
		this.coc_name = coc_name;
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
	
	
}
