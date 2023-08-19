package com.scaler.bookmyshow.service;

import com.scaler.bookmyshow.dto.BookingRequestDTO;
import com.scaler.bookmyshow.exception.BookingServiceException;
import com.scaler.bookmyshow.model.*;
import com.scaler.bookmyshow.repository.BookingRepository;
import com.scaler.bookmyshow.repository.CustomerRepository;
import com.scaler.bookmyshow.repository.MovieShowRepository;
import com.scaler.bookmyshow.repository.MovieShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MovieShowRepository movieShowRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MovieShowSeatRepository movieShowSeatRepository;

    @Transactional(isolation=Isolation.SERIALIZABLE)
    public Booking createBooking(BookingRequestDTO bookingRequestDTO){
        Customer customer = customerRepository
                .findById(bookingRequestDTO.getCustomerId())
                .orElseThrow(()->new BookingServiceException("Customer Details Not found","CUSTOMER_NOT_FOUND"));

        MovieShow movieShow = movieShowRepository
                .findById(bookingRequestDTO.getMovieShowId())
                .orElseThrow(()-> new BookingServiceException("MovieShow Details Not Found","MOVIE_SHOW_NOT_FOUND"));

        List<MovieShowSeat> seatList = movieShowSeatRepository.findAllById(bookingRequestDTO.getMovieShowSeat());

        if(seatList.size()!=bookingRequestDTO.getMovieShowSeat().size()){
            throw new BookingServiceException("All Seats are not available","ALL_SEATS_NOT_AVAILABLE");
        }

        for(MovieShowSeat movieShowSeat:seatList){
            if(movieShowSeat.getBookingStatus()!=SeatBookingStatus.AVAILABLE){
                throw new BookingServiceException("Requested Seat is not available","SEAT_NOT_AVAILABLE");
            }
        }

        for(MovieShowSeat movieShowSeat:seatList){
            movieShowSeat.setBookingStatus(SeatBookingStatus.RESERVED);
            movieShowSeatRepository.save(movieShowSeat);
        }

        Booking booking = Booking.builder()
                .customer(customer)
                .movieShow(movieShow)
                .movieShowSeats(seatList)
                .build();

        bookingRepository.save(booking);

        return booking;
    }
}
