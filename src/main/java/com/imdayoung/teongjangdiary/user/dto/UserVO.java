package com.imdayoung.teongjangdiary.user.dto;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserVO {

    private String userId;
    private String userNm;
    private String lgnId;
    private String lgnPwd;
    private String refreshToken;

    // 비밀번호 암호화 메소드
    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.lgnPwd = passwordEncoder.encode(this.lgnPwd);
    }

    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }
}
