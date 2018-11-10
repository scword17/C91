package com.conhj.B;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    public static void main(String args[]){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("application.xml");
        Person chinese=ctx.getBean("chinese", Person.class);
        chinese.eat();
//        String s=chinese.drunk("JAVA");
//        System.out.println("主函数返回值"+s);
    }
}
