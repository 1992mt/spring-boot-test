package com.wisedu.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames="mycacheone")
public class UserService {
	@Cacheable
	   public String getStudentName(int stdId) {
		System.out.println("execute getStudentName method...");
		if (stdId == 1) {
			return "Ramesh";
		} else {
			return "Mahesh";
		}
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

}
