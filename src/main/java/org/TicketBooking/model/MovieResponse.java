package org.TicketBooking.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MovieResponse {

    private String movieId;

    private String movieName;

    private String movieTimeStamp;

    private int availableSlots;

}
