package com.example.b2_ss8.aspect;

import com.example.b2_ss8.model.dto.request.BookTicketRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SanitizationAspect {

    @Around("execution(* com.example.b2_ss8.service.impl.TicketServiceImpl.bookTicket(..))")
    public Object sanitizePassengerName(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        BookTicketRequest request = (BookTicketRequest) args[0];
        String sanitizedName = request.getPassengerName().trim().toUpperCase();
        request.setPassengerName(sanitizedName);
        args[0] = request;
        return joinPoint.proceed(args);
    }
}