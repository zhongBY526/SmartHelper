package com.intern.agenttest.exception;


import lombok.Data;

@Data
public class BusinessException extends RuntimeException{
    private final Integer code;
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
