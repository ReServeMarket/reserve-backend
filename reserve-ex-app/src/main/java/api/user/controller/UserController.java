package api.user.controller;

import com.reserve.response.ApiResponse;
import api.user.controller.dto.UserLoginDto;
import api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**
     * (테스트용) 통합인증올 통해 발급받은 ci/phoneNumber -> 유저정보 조회 및 가입처리 후 토큰발급.
     */
    @PostMapping("/v1/login")
    public ApiResponse<UserLoginDto.Response> userLogin (@RequestBody UserLoginDto.Request requestDto) {
        return ApiResponse.ok(userService.userLogin(requestDto));
    }

    // TODO 2차 유저정보 저장 로직 구현 필요
}
