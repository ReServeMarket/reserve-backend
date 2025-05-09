package api.user.exception;


import com.reserve.exception.CustomException;
import api.user.enums.UserErrorCode;

public class UserNotFoundException extends CustomException {

    public UserNotFoundException() {
        super(UserErrorCode.USER_NOT_FOUND_ERROR);
    }

    public UserNotFoundException(String message) {
        super(UserErrorCode.USER_NOT_FOUND_ERROR, message);
    }
}
