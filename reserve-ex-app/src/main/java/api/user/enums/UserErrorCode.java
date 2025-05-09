package api.user.enums;

import com.reserve.code.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ResponseCode {

    USER_NOT_FOUND_ERROR("U001", "user not found"),
    USER_INACTIVE_ERROR("U002", "Inactive user"),
    USER_VIEW_DENIED_ERROR("U003", "Access to view the user is denied.");

    private final String statusCode;

    private final String message;
}
