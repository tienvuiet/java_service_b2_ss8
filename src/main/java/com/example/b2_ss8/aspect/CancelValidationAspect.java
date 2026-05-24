package com.example.b2_ss8.aspect;

import com.example.b2_ss8.model.entity.Flight;
import com.example.b2_ss8.model.entity.Ticket;
import com.example.b2_ss8.repository.FlightRepository;
import com.example.b2_ss8.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class CancelValidationAspect {
    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;
    @Before("execution(* com.example.b2_ss8.service.impl.TicketServiceImpl.cancelTicket(..))")
    public void validateCancel(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Long ticketId = (Long) args[0];

        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("ticket not found"));

        Flight flight = flightRepository.findById(ticket.getFlightId()).orElseThrow(() -> new RuntimeException("Flight not found"));

        long hours = Duration.between(
                LocalDateTime.now(),
                flight.getDepartureTime()
        ).toHours();

        if (hours < 24){
            throw  new RuntimeException("Cannot cancel within 24 hours");
        }
    }

}
