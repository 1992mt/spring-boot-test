package com.it.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Title: LogRecordAspect.java
 * @Package com.it.aspect
 * @Description: TODO
 * @author mt
 * @date 2017年7月2日 下午10:15:36
 * @version V1.0
 * @tags
 */
@Aspect // 定义一个切面
@Configuration
public class LogRecordAspect {
	private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);

	private long startTimeMillis = 0; // 开始时间
	private long endTimeMillis = 0; // 结束时间

	// 定义切点Pointcut
	@Pointcut("execution(* com.it.controller.*Controller.*(..))")
	public void excudeService() {
	}

	/**
	 * 
	 * @Title：doBeforeInServiceLayer
	 * @Description: 方法调用前触发 记录开始时间
	 * @param joinPoint
	 */
	@Before("execution(* com.it.controller..*.*(..))")
	public void doBeforeInServiceLayer(JoinPoint joinPoint) {
		startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
		  logger.debug("方法开始执行的时间:"+startTimeMillis);
	}
	
	/** 
     *  
     * @Title：doAfterInServiceLayer 
     * @Description: 方法调用后触发  
     *  记录结束时间 
     * @param joinPoint 
     */  
    @After("execution(* com.it.controller..*.*(..))")  
    public void doAfterInServiceLayer(JoinPoint joinPoint) {  
        endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间  
        logger.debug("方法执行完成的时间  :"+endTimeMillis);
    }  

    /** 
     *  
     * @Title：doAround 
     * @Description: 环绕触发  
     * @param pjp 
     * @return 
     * @throws Throwable 
     */  
	@Around("excudeService()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);

		// result的值就是被拦截方法的返回值
		Object result = pjp.proceed();
		logger.info("请求结束，controller的返回值是 " + result.toString());
		return result;
	}
}
