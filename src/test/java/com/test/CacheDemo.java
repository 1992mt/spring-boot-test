package com.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.it.service.UserService;
import com.it.springbootconfig.AppConfig;
public class CacheDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();

		UserService student = ctx.getBean(UserService.class);
		// calling getStudentName method first time.
		System.out.println(student.getStudentName(1));
		// calling getStudentName method second time with same parameter.
		//This time, method will not execute because result is cached with "mycacheone"
		System.out.println(student.getStudentName(1));
		// calling getStudentName method third time with different value.
		System.out.println(student.getStudentName(2));
		
		// calling getCity method first time.
		System.out.println(student.getCity(1));
		// calling getCity method second time with same parameter.
		//This time, method will not execute because result is cached with "mycachetwo"
		System.out.println(student.getCity(1));
		// calling getCity method third time with different value.
		System.out.println(student.getCity(2));
		ctx.close();
	}
} 