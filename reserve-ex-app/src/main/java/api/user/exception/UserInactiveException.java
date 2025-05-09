package api.user.exception;


import com.reserve.exception.CustomException;
import api.user.enums.UserErrorCode;

public class UserInactiveException extends CustomException {

    public UserInactiveException() {
        super(UserErrorCode.USER_INACTIVE_ERROR);
    }

    public UserInactiveException(String message) {
        super(UserErrorCode.USER_INACTIVE_ERROR, message);
    }
}
