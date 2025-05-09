package api.user.exception;

import com.reserve.exception.CustomException;
import api.user.enums.UserErrorCode;

public class UserViewDeniedException extends CustomException {

    public UserViewDeniedException() {
        super(UserErrorCode.USER_VIEW_DENIED_ERROR);
    }

    public UserViewDeniedException(String message) {
        super(UserErrorCode.USER_VIEW_DENIED_ERROR, message);
    }
}
