package com.imdayoung.teongjangdiary.global.response.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;
    private T payload;
    private ErrorResponse error;

    public static <T> ApiResponse<T> success(T data) {

        return ApiResponse.<T>builder()
                .success(true)
                .payload(data)
                .build();
    }

    public static ApiResponse<ErrorResponse> failure(ErrorResponse errorResponse) {

        return ApiResponse.<ErrorResponse>builder()
                .success(false)
                .error(errorResponse)
                .build();
    }
}
