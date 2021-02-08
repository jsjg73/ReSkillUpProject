package com.mycompany.domain;

public enum TargetDTO {
	여성, 남성, 유아, 노년, 청소년;
	
	public String getKey() {
        return name();
    }
	public String getValue() {
        return super.toString();
    }
}
