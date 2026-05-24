package com.example.b2_ss8.aspect;

import com.example.b2_ss8.model.entity.ErrorLog;
import com.example.b2_ss8.repository.ErrorLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ErrorLoggingAspect {

    private final ErrorLogRepository errorLogRepository;


    @AfterThrowing(
            pointcut = "execution(* com.example.b2_ss8.service.impl.*.*(..))",
            throwing = "ex"
    )
    public void logError(JoinPoint joinPoint, Exception ex) {
        ErrorLog errorLog = ErrorLog.builder()
                .timestamp(LocalDateTime.now())
                .methodName(joinPoint.getSignature().getName())
                .exceptionMessage(ex.getMessage())
                .build();
        errorLogRepository.save(errorLog);
    }
}