package com.example.b2_ss8.repository;

import com.example.b2_ss8.model.entity.Flight;
import com.example.b2_ss8.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
