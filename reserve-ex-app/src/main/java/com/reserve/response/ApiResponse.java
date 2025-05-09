package com.reserve.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.reserve.code.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private ResponseStatus status;
    // @Valid
    private T body;

    public static <T> ApiResponse<T> ok() {
        return ApiResponse.ok(null);
    }

    public static <T> ApiResponse<T> ok(T body) {
        var apiResponse = new ApiResponse<T>();
        apiResponse.status = ResponseStatus.ok();
        apiResponse.body = body;
        return apiResponse;
    }

    public static ApiResponse<Object> error(ResponseStatus status) {
        var apiResponse = new ApiResponse<Object>();
        apiResponse.status = status;
        return apiResponse;
    }

    public static ApiResponse<Object> error(ResponseCode status, String description) {
        var apiResponse = new ApiResponse<Object>();
        apiResponse.status = ResponseStatus.error(status,description);
        return apiResponse;
    }
}
