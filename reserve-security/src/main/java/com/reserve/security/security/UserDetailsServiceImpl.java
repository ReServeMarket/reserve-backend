package com.reserve.security.security;

import com.reserve.core.entity.user.User;
import com.reserve.core.repository.user.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import com.reserve.common.ConvertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userRepository.findByUserId(Long.valueOf(userId))
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("Failed Load User By UserId: " + userId));
    }

    private UserDetails createUserDetails(User user) {
        return UserDetailsImpl.builder()
                .userId(user.getUserId())
                .phoneNumber(user.getPhoneNumber())
                .roles(ConvertUtil.convertStrToArray(user.getAuthorityType().toString()))
                .build();
    }

}
