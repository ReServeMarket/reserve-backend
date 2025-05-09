package com.reserve.exception;


import com.reserve.code.CommonResponseCode;

public class BadRequestException extends CustomException {

    public BadRequestException() {
        super(CommonResponseCode.BAD_REQUEST_ERROR);
    }

    public BadRequestException(String message) {
        super(CommonResponseCode.BAD_REQUEST_ERROR, message);
    }
}
