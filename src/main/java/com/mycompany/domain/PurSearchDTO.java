package com.mycompany.domain;


public enum PurSearchDTO {
	제품명("pdt_name"),
	작성자("writer"),
	내용("bigo"),
	유형("pdt_type");
	
	public final String condi;
	private PurSearchDTO(String condi) {
		this.condi = condi;
	}
	
    public String getKey() {
        return super.name();
    }
    public String getCondi() {
    	return this.condi;
    }
	
	public String getValue() {
        return super.toString();
    }
	
//	
//	매핑
//	for(PurSearchDTO ps : PurSearchDTO.values())
//		System.out.println(ps.condi);
	
}
