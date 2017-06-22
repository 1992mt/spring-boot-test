package com.it.springbootconfig;

import java.util.Properties;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
* @Title: MyBatisMapperScannerConfig.java
* @Package com.wisedu.common
* @Description: MyBatis扫描接口
* @author mt
* @date 2017年6月25日 上午7:56:10
* @version V1.0
* @tags 
*/
@Configuration
//TODO 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
//这个配置一定要注意@AutoConfigureAfter(MyBatisConfig.class)，必须有这个配置，否则会有异常。原因就是这个类执行的比较早，由于sqlSessionFactory还不存在，后续执行出错。
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        /*MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");//与MyBatisConfig类中的sqlSessionFactory对应
        mapperScannerConfigurer.setBasePackage("tk.mybatis.springboot.mapper");
        return mapperScannerConfigurer;*/
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		mapperScannerConfigurer
//				.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.it.dao,com.it.mapper");
		Properties properties = new Properties();
	
		properties.put("mappers", "tk.mybatis.mapper.common.Mapper");
		//order mysql是自增长是after，oracle序列 uuid等是before
//		properties.put("ORDER", "BEFORE");
		properties.put("ORDER", "AFTER");
		mapperScannerConfigurer.setProperties(properties);
		
		return mapperScannerConfigurer;
    }
}
