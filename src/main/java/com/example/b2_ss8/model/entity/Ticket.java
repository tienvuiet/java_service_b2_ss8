package com.example.b2_ss8.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tickets")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passenger_name", nullable = false)
    private String passengerName;

    @Column(name = "flight_id")
    private Long flightId;

    @Column(name = "status")
    private String status;
}