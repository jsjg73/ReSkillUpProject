package com.mycompany.domain;


public enum SampSearchDTO {
	샘플ID("samp_id"),
	제품명("pdt_name"),
	유형("pdt_type"),
	제조사("coc_name"),
	작성자("writer");
	
	public final String condi;
	private SampSearchDTO(String condi) {
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
