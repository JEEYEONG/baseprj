//package kr.co.baseprj.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Aspect
//@Component
//public class MyAspect {
//    @Around("execution(* kr.co.baseprj..*(..))")
//    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
//      log.info("[log] {}", joinPoint.getSignature()); //join point 시그니처
//      return joinPoint.proceed();
//  }
//}
