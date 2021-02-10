package com.mycompany.domain;

import java.util.ArrayList;

public class AuthenticationCode {
	private static AuthenticationCode auth_code = null;
	private static ArrayList<Integer> code_list = null;

	private AuthenticationCode(){}

	public static AuthenticationCode getInstance() {
		if(auth_code == null) {
			auth_code = new AuthenticationCode();
			code_list = new ArrayList<>();
			code_list.add(1234);
		}
		return auth_code;
	}
	
	public boolean check(int code) {
		return code_list.contains(code);
	}
}
