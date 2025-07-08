package com.imdayoung.teongjangdiary.global.login.service;

import com.imdayoung.teongjangdiary.global.login.dto.CustomUserDetails;
import com.imdayoung.teongjangdiary.user.dto.UserVO;
import com.imdayoung.teongjangdiary.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String lgnId) throws UsernameNotFoundException {

        UserVO user = userMapper.findUserByLgnId(lgnId)
                .orElseThrow(() -> new UsernameNotFoundException("해당 아이디가 존재하지 않습니다."));

        return new CustomUserDetails(
                user.getLgnId(),
                user.getLgnPwd(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")),
                user.getUserId());

//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getLgnId())
//                .password(user.getLgnPwd())
//                .roles("USER")
//                .build();
    }
}
