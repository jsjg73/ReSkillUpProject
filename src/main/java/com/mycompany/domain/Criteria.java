package com.mycompany.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import oracle.net.aso.k;

@Setter
@Getter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	private String condi;
	private String keyword;
	
	public Criteria() {
		this(1,10);
		condi="#";
		keyword="#";
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}
