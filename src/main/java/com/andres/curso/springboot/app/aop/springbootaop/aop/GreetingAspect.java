package com.andres.curso.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

  private Logger logger;

  public GreetingAspect() {
    this.logger = LoggerFactory.getLogger(this.getClass());
  }

  @Before("execution(* com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
  public void loggerBefore(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("Antes: " + method + " con los argumentos " + args);
  }

  @After("execution(* com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
  public void loggerAfter(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("Despues: " + method + " con los argumentos " + args);
  }

  @AfterReturning("execution(* com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
  public void loggerAfterReturning(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("Despues de retornar: " + method + "con los argumentos " + args);
  }

  @AfterThrowing("execution(* com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
  public void loggerAfterThrowing(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("Despues de lanzar la excepción: " + method + "con los argumentos " + args);
  }

  @Around("execution(* com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
  public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    Object result = null;

    try {
      logger.info("El metodo " + method + "() con los parametros " + args);
      result = joinPoint.proceed();
      logger.info("El metodo " + method + "() retornal el resultado: " + result);
    } catch (Throwable e) {
      logger.error("Error en la llamada del metodo " + method + "()");
      throw e;
    }

    return result;
  }


}
