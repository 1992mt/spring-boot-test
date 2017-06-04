package com.wisedu.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wisedu.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/{id}")
	public User view(@PathVariable("id") Long id) {
		User user = new User();
		user.setId(id);
		user.setName("zhang");
		return user;
	}
	
	@RequestMapping("/index")
	public ModelAndView  index() {
		return new ModelAndView("index");
	}
}
