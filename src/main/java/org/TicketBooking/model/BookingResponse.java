package org.TicketBooking.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BookingResponse {

    private String movieName;

    private int noOfBookings;

    private String userEmailAddress;

    private boolean confirmed;

}
