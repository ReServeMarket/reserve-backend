package com.reserve.exception;

import com.reserve.code.ResponseCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final ResponseCode responseCode;
    private final String message;

    public CustomException(ResponseCode responseCode) {
        this.responseCode = responseCode;
        this.message = responseCode.getMessage();
    }

    public CustomException(ResponseCode responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }
}
