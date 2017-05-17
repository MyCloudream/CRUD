package com.oucre.service;

import java.util.Map;

public interface LoginService {
	/**
	 * 
	 * @param mobile   手机号码
	 * @param passwd  用户密码
	 * @return  
	 */
	public Map<String, Object> loginUser(String mobile, String passwd);
	
	
}
