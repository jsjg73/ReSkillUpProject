package com.mycompany.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private int totalPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total ) {
		
		this.total = total;
		this.cri = cri;
		
		this.endPage =(int) (Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage = this.endPage-9;
		this.totalPage = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(this.totalPage < this.endPage) {
			this.endPage = this.totalPage;
		}
		
		this.prev = this.startPage>1;
		this.next = this.endPage<this.totalPage;
		
	}
	
	
}
