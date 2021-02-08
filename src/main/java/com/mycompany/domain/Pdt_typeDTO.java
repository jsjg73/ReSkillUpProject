package com.mycompany.domain;

import java.util.ArrayList;
import java.util.List;

public enum Pdt_typeDTO {
	전자기기, 가구, 식품, 화장품;
	
    public String getKey() {
        return super.name();
    }
	
	public String getValue() {
        return super.toString();
    }

}
