package com.nutouchh.pract24.aspect;

import com.nutouchh.pract24.service.EmailService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmailAspect {
    @Autowired
    private EmailService emailService;

    @Async
    @AfterReturning("execution(public void com.nutouchh.pract24.service..*.addEntity(..))")
    public void sendEmail(JoinPoint joinPoint) {
        Object entity = joinPoint.getArgs()[0];
        String className = entity.getClass().getSimpleName();
        String messageText = "Object: " + entity + " successfully saved";
        emailService.sendEmail(className, messageText);
    }
}
