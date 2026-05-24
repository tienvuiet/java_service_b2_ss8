package com.example.b2_ss8.controller;

import com.example.b2_ss8.model.dto.request.BookTicketRequest;
import com.example.b2_ss8.model.entity.Ticket;
import com.example.b2_ss8.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    @PostMapping("/book")
    public Ticket bookTicket(@RequestBody BookTicketRequest request) {
        if (request.getPassengerName() == null
                || request.getPassengerName().trim().isEmpty()) {
            throw new RuntimeException("Passenger name cannot be blank");
        }
        return ticketService.bookTicket(request);
    }
    @PostMapping("/cancel/{ticketId}")
    public String cancelTicket(@PathVariable Long ticketId) {
        return ticketService.cancelTicket(ticketId);
    }
}