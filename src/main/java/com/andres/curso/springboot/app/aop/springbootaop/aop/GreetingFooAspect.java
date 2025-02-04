package com.andres.curso.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Aspect
@Component
public class GreetingFooAspect {

  private Logger logger;

  public GreetingFooAspect() {
    this.logger = LoggerFactory.getLogger(this.getClass());
  }

  @Before("execution(* com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
  public void loggerBefore(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("Antes: " + method + " invocados con los parametros " + args);
  }

  @After("execution(* com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
  public void loggerAfter(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("Despues: " + method + " invocados con los parametros " + args);
  }

}
