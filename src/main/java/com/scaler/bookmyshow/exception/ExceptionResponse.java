package com.scaler.bookmyshow.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {
    String msg;
    String errorCode;
}
