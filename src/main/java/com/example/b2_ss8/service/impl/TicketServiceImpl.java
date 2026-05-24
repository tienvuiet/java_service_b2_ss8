package com.example.b2_ss8.service.impl;

import com.example.b2_ss8.model.dto.request.BookTicketRequest;
import com.example.b2_ss8.model.entity.Flight;
import com.example.b2_ss8.model.entity.Ticket;
import com.example.b2_ss8.repository.FlightRepository;
import com.example.b2_ss8.repository.TicketRepository;
import com.example.b2_ss8.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;
    @Override
    public Ticket bookTicket(BookTicketRequest request) {
        Flight flight = flightRepository.findByFlightNumber(request.getFlightNumber()).orElseThrow(() -> new NoSuchElementException("Flight not found"));
        flight.setAvailableSeat(flight.getAvailableSeat() - 1);
        Ticket ticket = Ticket.builder()
                .flightId(flight.getId())
                .passengerName(request.getPassengerName())
                .status("BOOKED")
                .build();
        flightRepository.save(flight);
        return ticketRepository.save(ticket);
    }

    @Override
    public String cancelTicket(Long tiketId) {
        Ticket ticket = ticketRepository.findById(tiketId).orElseThrow(() -> new NoSuchElementException("TicketId not foung"));
        ticket.setStatus("CANCELED");
        ticketRepository.save(ticket);
        return "Cancel ticket success";
    }
}
