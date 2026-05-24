package com.example.b2_ss8.service;

import com.example.b2_ss8.model.dto.request.BookTicketRequest;
import com.example.b2_ss8.model.entity.Ticket;

public interface TicketService {
    Ticket bookTicket(BookTicketRequest request);
    String cancelTicket(Long tiketId);

}
