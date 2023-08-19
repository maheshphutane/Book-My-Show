package com.scaler.bookmyshow.service;

import com.scaler.bookmyshow.dto.BookingRequestDTO;
import com.scaler.bookmyshow.model.Booking;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    Booking createBooking(BookingRequestDTO bookingRequestDTO);
}
