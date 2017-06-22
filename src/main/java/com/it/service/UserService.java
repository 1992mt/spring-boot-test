package com.it.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.it.dao.UserMapper;
import com.it.entity.User;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Service
@CacheConfig(cacheNames = "mycacheone")
public class UserService {
	
	private static final Logger log = Logger.getLogger(UserService.class);

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private CacheManager cacheManager;

	@Cacheable
	public User getStudentName(int stdId) {
		System.out.println("execute getStudentName method...");
		User user = new User();
		user.setId(stdId);
		return userMapper.selectOne(user);
		// userMapper.selectByPrimaryKey(user);
		/*
		 * if (stdId == 1) { return "Ramesh"; } else { return "Mahesh"; }
		 */
	}

	@Cacheable(value = "mycachetwo")
	public String getCity(int cityId) {
		System.out.println("execute getCity method...");
		if (cityId == 1) {
			return "Varanasi";
		} else {
			return "Allahabad";
		}
	}

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	public Integer addUser(User user) {
		int l = userMapper.insert(user);
		return l;
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	public Integer updateUser(User user) {
		int updateByPrimaryKey = userMapper.updateByPrimaryKey(user);
		if(updateByPrimaryKey > 0){
			Cache cache = cacheManager.getCache("mycacheone");
			int size = cache.getSize();
			log.debug("cache-------------size:"+size);
			Element element = new Element(user.getId(),user);
			cache.put(element);
		}
		return updateByPrimaryKey;
	}

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return
	 */
	public Integer deleteUser(User user) {
		int delete = userMapper.delete(user);
		return delete;
	}

}
