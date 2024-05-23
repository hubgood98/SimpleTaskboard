package org.study.study240522.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Aspect
public class TimeTraceAop {

    @Around("execution(* org.study.study240522..*(..))") //study0522하위에 있는 모든 파일대상
    public Object execut(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("시작 : "+joinPoint.toString());
        try {
            return joinPoint.proceed(); //??
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("종료: "+joinPoint.toString()+" "+timeMs+"ms");
        }


    }
}
