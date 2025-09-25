package com.example.company.exceptions;

import com.example.company.commons.BaseResponseObj;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public BaseResponseObj handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return new BaseResponseObj(400, null , e.getMessage());
    }

    @ExceptionHandler(CustomException.class)
    public BaseResponseObj handleCustomException(CustomException e) {
        return new BaseResponseObj(e.getCode(), null , e.getMessage());
    }
}
