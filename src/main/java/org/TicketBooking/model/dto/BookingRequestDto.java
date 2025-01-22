package org.TicketBooking.model.dto;

import lombok.Data;

@Data
public class BookingRequestDto {

    private String movieName;

    private int noOfBookings;

    private String userEmailAddress;

}
