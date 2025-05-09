package api.user.service.dto;

import com.reserve.core.entity.user.enums.AuthorityType;
import com.reserve.core.entity.user.enums.GenderType;
import com.reserve.core.entity.user.enums.UserStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


import java.time.LocalDateTime;


@Getter
@Builder
@AllArgsConstructor
public class UserDto {

    private String userId;
    private String name;
    private String birthDate;
    private GenderType genderType;
    private String ci;
    private String phoneNumber;
    private UserStatusType userStatusType;
    private AuthorityType authorityType;
    private LocalDateTime registeredAt;

    // TODO : 2차 로그인 구현 시에 필드 추가 혹은 details 라는 별도 DTD 추가


}
