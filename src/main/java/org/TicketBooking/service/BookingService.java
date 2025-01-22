package org.TicketBooking.service;

import lombok.RequiredArgsConstructor;
import org.TicketBooking.model.BookingResponse;
import org.TicketBooking.model.MovieResponse;
import org.TicketBooking.model.dto.BookingRequestDto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingService {

    private final MovieService movieService;

    public synchronized BookingResponse bookMovie(BookingRequestDto bookingRequest) {
        BookingResponse bookingResponse = getResponseFromRequest(bookingRequest);
        String movieName = bookingRequest.getMovieName();
        int currentSlots = movieService.getRemainingSeats(movieName);
        if(currentSlots < bookingRequest.getNoOfBookings()){
            return bookingResponse;
        }else{
            int remaniningSlots = currentSlots - movieService.getRemainingSeats(movieName);
            movieService.updateRemaniningSlots(remaniningSlots, movieName);
            bookingResponse.setConfirmed(true);
            return bookingResponse;
        }
    }

    private BookingResponse getResponseFromRequest(BookingRequestDto bookingRequest) {
        return new BookingResponse().setNoOfBookings(bookingRequest.getNoOfBookings())
                .setConfirmed(false)
                .setUserEmailAddress(bookingRequest.getUserEmailAddress())
                .setMovieName(bookingRequest.getMovieName());
    }

}
