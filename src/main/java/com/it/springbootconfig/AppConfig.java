package com.it.springbootconfig;

import java.util.Arrays;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan("com.it")
//@EnableCaching
public class AppConfig {
//	 @Bean
	    public CacheManager cacheManager() {
	       SimpleCacheManager cacheManager = new SimpleCacheManager();
	       Cache cache1 = new ConcurrentMapCache("mycacheone");
	       Cache cache2 = new ConcurrentMapCache("mycachetwo");
	       cacheManager.setCaches(Arrays.asList(cache1, cache2));
	       return cacheManager;
	    }
}
