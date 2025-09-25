package com.example.company.commons;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponseObj {
    private int code;
    private Object data;
    private String msg;

    public BaseResponseObj(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
