package com.scaler.bookmyshow.controller;

import com.scaler.bookmyshow.dto.BookingRequestDTO;
import com.scaler.bookmyshow.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bms/v1")
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<String> createBooking(@RequestBody BookingRequestDTO bookingRequestDTO){
        bookingService.createBooking(bookingRequestDTO);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}
