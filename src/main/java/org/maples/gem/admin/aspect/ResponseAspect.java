package org.maples.gem.admin.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class ResponseAspect {

    @Around("execution(* org.maples.gem.admin.controller.StockController.*(..))")
    public Object generalReturn(ProceedingJoinPoint joinPoint) {
        Map<String, Object> response = new HashMap<>();

        try {
            Object result = joinPoint.proceed();
            response.put("errorNumber", 0);
            response.put("errorMessage", "success");
            response.put("data", result);

        } catch (RuntimeException e) {
            response.put("errorNumber", 1);
            response.put("errorMessage", "success");
            response.put("data", e.getLocalizedMessage());
        } catch (Exception e) {
            response.put("errorNumber", 2);
            response.put("errorMessage", "success");
            response.put("data", e.getLocalizedMessage());
        } catch (Throwable e) {
            response.put("errorNumber", 3);
            response.put("errorMessage", "success");
            response.put("data", e.getLocalizedMessage());
        }

        log.info("{}, {}", response.get("errorNumber"), response.get("errorMessage"));

        return response;
    }
}
