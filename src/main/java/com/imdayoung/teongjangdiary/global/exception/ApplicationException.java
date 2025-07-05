package com.imdayoung.teongjangdiary.global.exception;

import com.imdayoung.teongjangdiary.global.response.error.ApplicationError;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException {

    private final HttpStatus status;
    private final String code;

    public ApplicationException(ApplicationError error) {

        super(error.getMessage());
        this.status = error.getStatus();
        this.code = error.getCode();
    }
}
