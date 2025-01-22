package org.TicketBooking.model.dto;

import lombok.Data;

@Data
public class MovieRequestDto {

    private String movieName;

    private String movieTimeStamp;

    private int availableSlots;

}
