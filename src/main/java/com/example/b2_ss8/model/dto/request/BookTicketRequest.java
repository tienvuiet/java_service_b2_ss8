package com.example.b2_ss8.model.dto.request;

import lombok.Data;

@Data
public class BookTicketRequest {

    private String flightNumber;

    private String passengerName;
}