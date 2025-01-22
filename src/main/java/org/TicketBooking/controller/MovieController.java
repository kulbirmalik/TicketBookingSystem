package org.TicketBooking.controller;

import lombok.RequiredArgsConstructor;
import org.TicketBooking.model.MovieResponse;
import org.TicketBooking.model.dto.MovieRequestDto;
import org.TicketBooking.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<MovieResponse> createMovie(@RequestBody MovieRequestDto movieRequestDto){
        return ResponseEntity.ok(movieService.createMovie(movieRequestDto));
    }

    @GetMapping("/{movieName}")
    public ResponseEntity<MovieResponse> getMovieDetails(@PathVariable("movieName") String movieName){
        return ResponseEntity.ok(movieService.getMovieDetails(movieName));
    }

}
