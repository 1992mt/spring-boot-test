package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration  
//@ComponentScan  //默认扫描该启动类所在根路径下所有包（包括子级）路径
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication//作用包含了@ComponentScan 和@Configuration 
@EnableAutoConfiguration//开启自动配置
@EnableCaching
//开启spring对Aspectj的支持
@EnableAspectJAutoProxy
public class Application {
	@Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }
	public static void main(String[] args) {  
        SpringApplication.run(Application.class);  
    }  
}
