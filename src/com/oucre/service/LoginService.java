package com.oucre.service;

import java.util.Map;

public interface LoginService {
	/**
	 * 
	 * @param mobile   �ֻ�����
	 * @param passwd  �û�����
	 * @return  
	 */
	public Map<String, Object> loginUser(String mobile, String passwd);
	
	
}
