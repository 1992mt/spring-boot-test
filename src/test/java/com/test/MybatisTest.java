package com.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.it.Application;
import com.it.dao.UserMapper;
import com.it.entity.User;

/**
* @Title: MybatisTest.java
* @Package com.test
* @Description: TODO
* @author mt
* @date 2017年6月25日 上午8:42:45
* @version V1.0
* @tags 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)  
public class MybatisTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void getAllUser(){
		List<User> list = userMapper.selectAll();
		for (User user : list) {
			System.out.println(user.getId()+">>>>:"+user.getUname());
		}
	}
	
	@Test
	public void getByPage(){
		 PageHelper.startPage(0, 3);
		List<User> list = userMapper.selectAll();
		for (User user : list) {
			System.out.println(user.getId()+">>>>:"+user.getUname());
		}
	}
}
