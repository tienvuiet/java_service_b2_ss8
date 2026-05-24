package com.example.b2_ss8.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "flight_number", nullable = false)
    private String flightNumber;
    @Column(name = "daparture_time")
    private LocalDateTime departureTime;
    @Column(name = "available_seat")
    private Integer availableSeat;
}
