package com.it.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.customannotation.ChangeResponse;
import com.it.entity.Logs;
import com.it.entity.User;
import com.it.service.LogsService;
import com.it.service.UserService;
import com.it.util.RequestUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RequestUtil requestUtil;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private LogsService logsService;
	
	@RequestMapping("/{id}")
	@ChangeResponse
	public User getUsers(@PathVariable("id") Integer id) {
		String ip = requestUtil.getIp();
		log.debug(ip);
		User user = userService.getStudentName(id);
		if(null == user){
			return null;
		}
		log.debug(user.getId()+","+user.getUname());
		return user;
		/*User user = new User();
		user.setId(id);
		user.setName("zhang");
		return user;*/
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@ChangeResponse
	public User getUser(@PathVariable("id") Integer id) {
		User user = this.getUsers(id);
		return user;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.POST)
	public Integer updateUser(@PathVariable("id") Integer id) {
		User user = this.getUsers(id);
		user.setPass("1234567");
		user.setCreatedate(new Date());
		user.setUdec("测试用户");
		user.setUname("test");
		Integer updateUser = userService.updateUser(user);
		return updateUser;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public Integer addUser(@PathVariable("id") Integer id) {
		User user = new User();
		user.setPass("7654321");
		user.setCreatedate(new Date());
		user.setUdec("增加用户");
		user.setUname("testadd");
		Integer addUser = userService.addUser(user);
		return addUser;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public Integer deleteUser(@PathVariable("id") Integer id) {
		User user = this.getUsers(id);
		Integer deleteUser = userService.deleteUser(user);
		return deleteUser;
	}
	
	@RequestMapping(value="/{content}")
	public Integer testLogs(@PathVariable("content") String content) {
		Logs logs = new Logs();
		logs.setIp(request.getRemoteHost());
		logs.setText("数据库回滚测试");
		Integer saveLog = logsService.saveLog(logs);
		return saveLog;
	}
}
