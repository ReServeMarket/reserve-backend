package api.user.service;

import ch.qos.logback.core.util.StringUtil;
import com.reserve.core.entity.user.User;
import api.user.exception.UserNotFoundException;
import com.reserve.core.entity.user.enums.AuthorityType;
import com.reserve.core.entity.user.enums.GenderType;
import com.reserve.core.entity.user.enums.UserStatusType;
import com.reserve.core.repository.user.UserRepository;
import api.user.controller.dto.UserLoginDto;
import api.user.service.dto.UserDto;
import com.reserve.security.security.JwtTokenProvider;
import com.reserve.security.security.TokenDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.log.LogMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 내부 테스트용 임시 토큰 발급 처리 및 회원가입
     */
    @Transactional
    public UserLoginDto.Response userLogin(UserLoginDto.Request requestDto) {

        User saveUser = userRepository.findByCi(requestDto.getCi()).orElseGet(
                () -> this.saveUser(
                        UserDto.builder()
                                .ci(requestDto.getCi())
                                .phoneNumber(requestDto.getPhoneNumber())
                                .name("TESTER")
                                .genderType(GenderType.MALE)
                                .birthDate("00000000")
                                .userStatusType(UserStatusType.PROFILE_REGISTRATION)
                                .authorityType(AuthorityType.ROLE_USER)
                                .registeredAt(LocalDateTime.now())
                                .build()

                )
        );
        log.info(String.valueOf(LogMessage.format("Saved user " + saveUser.getUserId())));

        TokenDataDto tokenData = jwtTokenProvider.createToken(
                String.valueOf(saveUser.getUserId()), requestDto.getPhoneNumber());

        if (StringUtil.isNullOrEmpty(tokenData.getAccessToken())) {
            log.error("Failed issue access token");
        }

        return UserLoginDto.Response.builder()
                .userId(saveUser.getUserId())
                .tokenData(tokenData)
                .build();
    }
  
  
    /**
     * user 정보를 저장한다. -> 추가 정보는 업데이트 받을 수 있도록한다.
     */
    @Transactional
    public User saveUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .genderType(userDto.getGenderType())
                .birthdate(userDto.getBirthDate())
                .phoneNumber(passwordEncoder.encode(userDto.getPhoneNumber()))
                .ci(userDto.getCi())  // TODO : aes256 암호화 방식 적용
                .userStatusType(userDto.getUserStatusType())
                .authorityType(userDto.getAuthorityType())
                .registeredAt(userDto.getRegisteredAt())
                .build();

        return userRepository.save(user);
    }
  
    /**
     * UserCi 를 적용하여 사용자가 존재하는지 확인
     * TODO : CI 암호화 방식에 대해 고려해야함.
     */
    public Optional<User> findByUserCi(String ci) {
        return userRepository.findByCi(ci);
    }
  
    
    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}
