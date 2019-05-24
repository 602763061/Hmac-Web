package com.imooc.girl.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.Joinable;


@Aspect
@Component
public class HttpAspect {


    //用log的形式打印
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public *  com.imooc.girl.contoller.HmacController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void before(JoinPoint joinPoint){

        ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //method
       logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());


        //类方法

        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数

        logger.info("args={}",joinPoint.getArgs());






    }

    @After("log()")
    public void after(){
        logger.info("333333333333333");

    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doafterreturn(Object object){

      //  logger.info("request={}",object);

    }
}
