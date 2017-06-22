package com.it.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.entity.Logs;
import com.it.service.LogsService;

/**
* @Title: TransactionController.java
* @Package com.it.controller
* @Description: TODO
* @author mt
* @date 2017年7月2日 下午9:49:16
* @version V1.0
* @tags 
*/
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private LogsService logsService;
	
	@Autowired
	private HttpServletRequest request;

	//对Error异常和RuntimeException异常以及其子类进行事务回滚，且必须对抛出异常
	@RequestMapping(value="/un/{content}")
	//@Transactional(rollbackFor=MyException.class,noRollbackFor=OtherException.class)
	//注：若rollbackFor和noRollbackFor配置的类相同，则出现对应异常会进行回滚
	@Transactional
	public Integer testLogsUnchecked(@PathVariable("content") String content) throws Exception {
		Integer saveLog =null;
		try {
			Logs logs = new Logs();
			logs.setIp(request.getRemoteHost());
			logs.setText(content);
			 saveLog = logsService.saveLog(logs);
			Integer.parseInt("we");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return saveLog;

	}
	
	//已检查异常（checked）,数据库不回滚
	@RequestMapping(value="/ch/{content}")
	@Transactional
	public Integer testLogsChecked(@PathVariable("content") String content) throws Exception {
		Integer saveLog =null;
		try {
			Logs logs = new Logs();
			logs.setIp(request.getRemoteHost());
			logs.setText(content);
			 saveLog = logsService.saveLog(logs);
			 File file = new File("D://test.txt");
			 InputStream is = new FileInputStream(file);
		} catch (FileNotFoundException e) {//已检查异常（checked）异常
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw e;
		}
		return saveLog;

	}
}
