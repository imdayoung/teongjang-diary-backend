package com.imdayoung.teongjangdiary.global.response.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ApplicationError {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_001", "서버 내부 에러가 발생했습니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON_002", "사용자가 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
