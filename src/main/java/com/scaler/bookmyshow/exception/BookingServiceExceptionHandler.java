package com.scaler.bookmyshow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookingServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookingServiceException.class)
    public ResponseEntity<ExceptionResponse> exceptionHandler(BookingServiceException bookingServiceException){
        return new ResponseEntity<>(ExceptionResponse.builder()
                .msg(bookingServiceException.getMsg())
                .errorCode(bookingServiceException.getErrorCode()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
