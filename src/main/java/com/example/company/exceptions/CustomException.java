package com.example.company.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {

    private int code;

    public CustomException(int code, String msg) {
        super(msg);
        this.code = code;
    }

}
