package com.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dao.LogsMapper;
import com.it.entity.Logs;

/**
* @Title: LogsService.java
* @Package com.it.service
* @Description: TODO
* @author mt
* @date 2017年7月2日 下午9:36:28
* @version V1.0
* @tags 
*/
@Service
public class LogsService {
	
	@Autowired
	private LogsMapper logsMapper;
	
	public  Integer saveLog(Logs  logs){
		return logsMapper.insert(logs);
	}

}
