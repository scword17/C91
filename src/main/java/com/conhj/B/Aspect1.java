package com.conhj.B;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/*
*  已发现问题：Around与AfterReturning共用，Around与AfterReturning共用会出现bug，第一种组合返回null，第二种不抛出异常
*
* */
@Aspect
public class Aspect1 {
    @Before("execution(* com.conhj.B.*.*(..))")
    public void xishou(){
        System.out.println("洗手");
    }

    @After("execution(* com.conhj.B.*.*(..))")
    public void flush(){
        System.out.println("上厕所");
    }

    @AfterReturning(returning = "rvt",pointcut = "execution(* com.conhj.B.*.*(..))")
    public void back(Object rvt){
        System.out.println("返回值"+rvt);
        System.out.println("后置返回执行了！");
    }
    @Around("execution(* com.conhj.A.*.*(..))")
    public void arround(ProceedingJoinPoint jp){
        System.out.println("环绕增强before");
        try{
           if(jp.getArgs().length!=0) {
               Object[] ob = new Object[jp.getArgs().length];
               ob=jp.getArgs();
               System.out.println("环绕核心"+ob[0]);
               ob[0]="JSON";
               jp.proceed(ob);
           }
        }catch(Throwable e){
            e.printStackTrace();
        }
        System.out.println("环绕增强After");
    }

    @AfterThrowing( pointcut= "execution(* com.conhj.B.*.*(..))",throwing = "rt")
    public void throwException(Throwable rt){
        System.out.println("异常拦截");
        System.out.println("异常是"+rt.getMessage());
    }



}
