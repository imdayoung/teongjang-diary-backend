package com.imdayoung.teongjangdiary.global.response.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String code;
    private String message;
}
