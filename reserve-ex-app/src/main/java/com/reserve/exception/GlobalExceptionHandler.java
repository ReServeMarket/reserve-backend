package com.reserve.exception;

import com.reserve.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.log.LogMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ApiResponse<Object> handleCustomException(CustomException e) {

        log.error(String.valueOf(LogMessage.format("Exception occurred",
                com.reserve.common.logger.LogMessage.KeyValueData.of("statusCode", e.getResponseCode()),
                com.reserve.common.logger.LogMessage.KeyValueData.of("message", e.getMessage()))));

        return ApiResponse.error(e.getResponseCode(), e.getMessage());
    }
}
