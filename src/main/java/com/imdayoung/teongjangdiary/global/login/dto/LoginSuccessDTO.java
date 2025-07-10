package com.imdayoung.teongjangdiary.global.login.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginSuccessDTO {

    private String userId;
    private String accessToken;
    private String refreshToken;
}
