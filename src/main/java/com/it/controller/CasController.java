package com.it.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it.springbootconfig.SpringCasAutoconfig;

import io.swagger.models.Response;
/**
 * 
* @ClassName: CasController
* @Description: 
* @author  mt
* @date 2017年7月26日 上午9:27:03
* @Copyright: Copyright (c) 2017 wisedu
 */
@Controller
@RequestMapping("/sp/cas")
public class CasController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SpringCasAutoconfig springCasAutoconfig;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public void getUser(HttpServletRequest request,HttpServletResponse response) {
		String username=request.getRemoteUser();
		request.setAttribute("username", username);
		String  logoutUrl=springCasAutoconfig.getCasServerUrlPrefix()+springCasAutoconfig.getSignOutFilters().get(0)+"?service="+"http://127.0.0.1:8082/sp/cas/index";
//		request.getSession().invalidate();
		System.out.println("logoutUrl{}:"+logoutUrl);
		log.debug("logoutUrl{}:",logoutUrl);
		try {
			response.sendRedirect(logoutUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return "redirect:"+logoutUrl;
	}
	
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		request.setAttribute("username", "testcas!");
		return "index";
	}
	
}
