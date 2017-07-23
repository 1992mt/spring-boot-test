package com.it.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.it.service.UserService;

/**
* @Title: RequestUtil.java
* @Package com.it.util
* @Description: TODO
* @author mt
* @date 2017年7月2日 下午8:29:55
* @version V1.0
* @tags 
*/
@Component
public class RequestUtil {
	
	@Autowired
	private  HttpServletRequest request;
	
	@Autowired
	private UserService userService;
	
	public  String getIp(){
		String ip = request.getRemoteHost();
		return ip;
	}
	
	protected  String getPIP(){
		String ip = request.getRemoteHost();
		return ip;
	}

}
