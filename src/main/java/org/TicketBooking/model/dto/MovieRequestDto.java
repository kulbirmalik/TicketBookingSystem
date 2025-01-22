package org.TicketBooking.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MovieRequestDto {

    private String movieName;

    private String movieTimeStamp;

    private int availableSlots;

}
