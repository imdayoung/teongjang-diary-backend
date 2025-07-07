package com.imdayoung.teongjangdiary.user.service;

import com.imdayoung.teongjangdiary.user.dto.UserVO;
import com.imdayoung.teongjangdiary.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserVO user) {
        user.passwordEncode(passwordEncoder);
        userMapper.insertUser(user);
    }
}
