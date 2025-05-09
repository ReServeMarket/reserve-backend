package com.reserve.code;


//TODO : 1. 성공과 실패에 대한 코드를 나누는 것에 대한 고려
//       2. 공통적으로 사용될 코드에 대해서는 상의 후 수정 필요 -> 이후에는 필요에 의해 추가

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonResponseCode implements ResponseCode {

    OK("C000" , "success") ,

    BAD_REQUEST_ERROR("C001", "api bad request exception") ,

    REQUEST_BODY_MISSING_ERROR("C002", "required request body is missing"),

    MISSING_REQUEST_PARAMETER_ERROR( "C003", "missing servlet requestParameter exception"),

    IO_ERROR("C004", "I/O exception"),

    JSON_PARSE_ERROR("C005", "json parse exception"),

    JACKSON_PROCESS_ERROR("C006", "com.fasterxml.jackson.core exception"),

    FORBIDDEN_ERROR("C007", "forbidden exception"),

    NOT_FOUND_ERROR("C008", "not found exception"),

    NULL_POINT_ERROR("C009", "null point exception"),

    NOT_VALID_ERROR("C010", "handle validation exception"),

    NOT_VALID_HEADER_ERROR("C011", "not valid header exception"),

    INTERNAL_SERVER_ERROR("C999", "internal server error exception"),

    ;

    private final String statusCode;

    private final String message;

}
