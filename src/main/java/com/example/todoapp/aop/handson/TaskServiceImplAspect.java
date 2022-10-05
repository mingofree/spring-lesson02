package com.example.todoapp.aop.handson;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// 1 アノテーションを追加
@Aspect
@Component  // Bean として登録するために必要
public class TaskServiceImplAspect {

    // 2 アノテーションとpointcut式を追加
    @Before("target(com.example.todoapp.service.TaskService)")
    public void before(JoinPoint jp) {
        System.out.println("Before: " + jp.getSignature() + " 実行日時: (" + LocalDateTime.now() + ")");
    }

    // 4 アノテーションとpointcut式を追加
    @After("execution(* *..TaskServiceImpl.get*(..))")
    public void after(JoinPoint jp) {
        System.out.println("After: " + jp.getSignature() + " 実行日時: (" + LocalDateTime.now() + ")");
    }

    // 6 アノテーションとpointcut式を追加
    // @AfterThrowing(value = "target(com.example.todoapp.service.TaskService)", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        System.out.println("AfterThrowing: " + jp.getSignature());
        e.printStackTrace();
    }
}
