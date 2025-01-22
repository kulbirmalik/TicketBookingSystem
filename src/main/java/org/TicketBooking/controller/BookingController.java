package org.TicketBooking.controller;


import lombok.RequiredArgsConstructor;
import org.TicketBooking.model.BookingResponse;
import org.TicketBooking.model.dto.BookingRequestDto;
import org.TicketBooking.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @RequestMapping
    public ResponseEntity<BookingResponse> bookMovie(BookingRequestDto bookingRequest){
        return ResponseEntity.ok(bookingService.bookMovie(bookingRequest));
    }
}
