package com.easy.app.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {

    //Логируются только контроллеры, иначе совсем мешанина из логов получается
    @Pointcut(value = "execution(* com.easy.app.product.*.controller.*.*(..))")
    public void pointCut() {

    }

    @Around(value = "pointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        var mapper = new ObjectMapper();
        var methodName = pjp.getSignature().getName();
        var className = pjp.getTarget().getClass().toString();
        var args = mapper.writeValueAsString(pjp.getArgs());
        log.info("class name: {}, method name: {}, arguments Request: {}", className, methodName, args);

        var object = pjp.proceed();
        log.info("class name: {}, method name: {}, arguments Response: {}", className, methodName, mapper.writeValueAsString(object));
        return object;
    }
}
