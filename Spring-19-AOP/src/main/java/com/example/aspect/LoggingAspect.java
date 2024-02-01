package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.example.controller.CourseController.*(..))")
//    private  void pointcut(){
//    }
//
//    @Before("pointcut()")
//    public void log(){
//        logger.info("Logger info ---------");
//    }

//    @Before("execution(* com.example.controller.CourseController.*(..))")
//    public void beforeAdvice(){
//        logger.info("Logger info ---------");
//    }

//    @Pointcut("execution(* com.example.repository.CourseRepository.findById(*))")
//    private void anyProductRepositoryFindById(){}
//
//    @Before("anyProductRepositoryFindById()")
//    public void beforeCourseRepoOperation(JoinPoint joinPoint){
//        logger.info("Before (findById): -> Method: {} - Arguments: {} - Target: {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
//    }

//    @Pointcut("within(com.example.controller..*)")
//    private void anyControllerOperation(){}
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    private void anyServiceOperation(){}
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeCourseControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before () -> Method : {} - Arguments : {} - Target: {}", joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
//    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetCourseOperation(){}

//    @Before("anyDeleteCourseOperation()")
//    private void beforeControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before () -> Method : {} - Arguments : {} - Target: {}", joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
//    }

//    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
//    public void afterReturningControllerAdvice(JoinPoint joinPoint,Object result){
//        logger.info("After returning -> Method: {} - result{}", joinPoint.getSignature().toShortString(),result.toString() );
//    }
//
//    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
//    public void afterReturningControllerAdvice(JoinPoint joinPoint, List<Object> result){
//        logger.info("After returning(List) -> Method: {} - result{}", joinPoint.getSignature().toShortString(),result.toString() );
//    }

//    @AfterThrowing(pointcut = "anyGetCourseOperation()", throwing = "exception")
//    public void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception){
//        logger.info("After Throwing -> Method: {} - Exception: {}",joinPoint.getSignature().toShortString(),exception.getMessage());
//    }

//    @After("anyGetCourseOperation()")
//    public void afterControllerAdvice(JoinPoint joinPoint){
//        logger.info("After finally -> Method : {}", joinPoint.getSignature().toShortString());
//    }

    @Pointcut("@annotation(com.example.annotation.Loggable)")
    public void anyLoggableMethodOperation(){}

    @Around("anyLoggableMethodOperation()")
    public Object anyLoggableMethodOperationAdvice(ProceedingJoinPoint joinPoint)  {
        logger.info("Before () -> Method : {} - Parameters: {}", joinPoint.getSignature().toShortString(),joinPoint.getArgs());
        Object result = null;
        try {
            result = joinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }
        logger.info("After -> Method: {} - Results: {}",joinPoint.getSignature().toShortString(),result.toString());
        return result;
    }
}