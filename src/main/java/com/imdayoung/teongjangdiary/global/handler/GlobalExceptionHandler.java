package com.imdayoung.teongjangdiary.global.handler;

import com.imdayoung.teongjangdiary.global.exception.ApplicationException;
import com.imdayoung.teongjangdiary.global.response.response.ApiResponse;
import com.imdayoung.teongjangdiary.global.response.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleApplicationException(ApplicationException e) {

        ErrorResponse errorResponse = new ErrorResponse(e.getCode(), e.getMessage());
        ApiResponse<ErrorResponse> response = ApiResponse.failure(errorResponse);
        return new ResponseEntity<>(response, e.getStatus());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleNoHandlerFoundException() {

        ErrorResponse errorResponse = new ErrorResponse("COMMON_000", "존재하지 않는 리소스입니다.");
        ApiResponse<ErrorResponse> response = ApiResponse.failure(errorResponse);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiResponse<ErrorResponse>> handleException(Exception e) {
//
//        ApplicationError error = ApplicationError.INTERNAL_SERVER_ERROR;
//        ErrorResponse errorResponse = new ErrorResponse(error.getCode(), error.getMessage());
//        ApiResponse<ErrorResponse> response = ApiResponse.failure(errorResponse);
//        return new ResponseEntity<>(response, error.getStatus());
//    }
}
