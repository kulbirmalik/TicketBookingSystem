package org.TicketBooking.service;

import org.TicketBooking.model.MovieResponse;
import org.TicketBooking.model.dto.MovieRequestDto;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MovieService {

    ConcurrentHashMap<String, String> movieNameToMovieIdMap = new ConcurrentHashMap<>();

    ConcurrentHashMap<String, MovieResponse> movieResponseToMovieIdMap = new ConcurrentHashMap<>();

    public MovieResponse createMovie(MovieRequestDto movieRequestDto){
        String movieId = UUID.randomUUID().toString();
        String movieName = movieRequestDto.getMovieName();
        MovieResponse movieResponse = getResponseFromRequestDto(movieRequestDto, movieId);
        movieResponseToMovieIdMap.putIfAbsent(movieId, movieResponse);
        movieNameToMovieIdMap.putIfAbsent(movieName, movieId);
        return movieResponse;
    }

    public MovieResponse getMovieDetails(String movieName){
        if(movieNameToMovieIdMap.containsKey(movieName)){
            String movieId = movieNameToMovieIdMap.get(movieName);
            return movieResponseToMovieIdMap.get(movieId);
        }
        throw new RuntimeException("Movie Name Not Registered with system :  " + movieName);
    }

    public int getRemainingSeats(String movieName){
        if(movieNameToMovieIdMap.containsKey(movieName)){
            String movieId = movieNameToMovieIdMap.get(movieName);
            return movieResponseToMovieIdMap.get(movieId).getAvailableSlots();
        }
        throw new RuntimeException("Movie Name Not Registered with system :  " + movieName);
    }

    private MovieResponse getResponseFromRequestDto(MovieRequestDto movieRequestDto, String movieId){
        return new MovieResponse().setMovieId(movieId)
                .setMovieName(movieRequestDto.getMovieName())
                .setMovieTimeStamp(movieRequestDto.getMovieTimeStamp())
                .setAvailableSlots(movieRequestDto.getAvailableSlots());
    }

    public void updateRemaniningSlots(int remaniningSlots, String movieName) {
        String movieId = movieNameToMovieIdMap.get(movieName);
        MovieResponse movieResponse =  movieResponseToMovieIdMap.get(movieId);
        movieResponse.setAvailableSlots(remaniningSlots);
    }
}
