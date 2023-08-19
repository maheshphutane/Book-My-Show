package com.scaler.bookmyshow.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BookingServiceException extends RuntimeException{
    String msg;
    String errorCode;
    public BookingServiceException(String msg,String errorCode){
        super(msg);
        this.msg = msg;
        this.errorCode = errorCode;
    }
}
