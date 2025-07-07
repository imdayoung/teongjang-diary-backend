package com.imdayoung.teongjangdiary.user.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Builder
public class UserVO {

    String userId;
    String userNm;
    String lgnId;
    String lgnPwd;
    String refreshToken;

    // 비밀번호 암호화 메소드
    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.lgnPwd = passwordEncoder.encode(this.lgnPwd);
    }

    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }
}
