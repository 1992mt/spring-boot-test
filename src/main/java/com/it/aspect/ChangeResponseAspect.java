package com.it.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.it.entity.User;

/**
 * 自定义注解的切面
 * 
 * @author mt
 *
 */
@Aspect
@Component
public class ChangeResponseAspect {

	@Pointcut("@annotation(com.it.customannotation.ChangeResponse)")
	public void annotationPointCut() {
	}

	@Before("annotationPointCut()")
	public void before(JoinPoint joinPoint) {
		MethodSignature sign = (MethodSignature) joinPoint.getSignature();
		Method method = sign.getMethod();
		System.out.print("接受方法：" + method.getName() + " 前置日志");
	}

	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature sign = (MethodSignature) joinPoint.getSignature();
		Method method = sign.getMethod();
		System.out.print("接受方法：" + method.getName() + " 前置日志");
	}

	@Around("annotationPointCut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		System.out.println("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}" + url + method + uri + queryString);

		// result的值就是被拦截方法的返回值
		Object result = pjp.proceed();
		System.out.println("请求结束，controller的返回值是 " + result.toString());
		if (result instanceof User) {
			System.out.println("++++++++++++++++++++++++++++++++sfvfdg+++++++++++++++++++++++++++");
			User user = (User) result;
			user.setCreatedate(new Date());
			user.setId(1009);
			user.setPass("345321");
			user.setUdec("aop切面修改返回值");
			user.setUname("aop测试");
			System.out.println("------------------------------gregfref------------------------------------");
			return user;
		} else {
			return result;
		}
	}
}
