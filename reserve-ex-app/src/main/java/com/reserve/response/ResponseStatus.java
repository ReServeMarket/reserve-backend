package com.reserve.response;

import com.reserve.code.CommonResponseCode;
import com.reserve.code.ResponseCode;
import lombok.*;



@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseStatus {

    private String statusCode;

    private String message;

    private String description;


    public static ResponseStatus ok(){
        return ResponseStatus.builder()
                .statusCode(CommonResponseCode.OK.getStatusCode())
                .message(CommonResponseCode.OK.getMessage())
                .build();
    }

    public static ResponseStatus error() {
        return ResponseStatus.builder()
                .statusCode(CommonResponseCode.INTERNAL_SERVER_ERROR.getStatusCode())
                .message(CommonResponseCode.INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }

    public static ResponseStatus error(ResponseCode responseCode) {
        return ResponseStatus.builder()
                .statusCode(responseCode.getStatusCode())
                .message(responseCode.getMessage())
                .build();
    }

    public static ResponseStatus error(ResponseCode responseCode, String description) {
        return ResponseStatus.builder()
                .statusCode(responseCode.getStatusCode())
                .message(responseCode.getMessage())
                .description(description)
                .build();
    }

}
