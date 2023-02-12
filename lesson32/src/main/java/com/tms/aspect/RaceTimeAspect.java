package com.tms.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RaceTimeAspect {
    @Pointcut("@annotation(com.tms.annotation.TimeCheck)")
    public void pointCutForTimeCheck() {
    }

    @Around("pointCutForTimeCheck()")
    public Object printRaceTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Race time, mls: " + (end - start));
        return result;
    }

}
