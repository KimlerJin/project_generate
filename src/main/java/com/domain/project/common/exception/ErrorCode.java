package com.domain.project.common.exception;

import java.text.MessageFormat;

/**
 * @Description :
 * ---------------------------------
 * @Auther: Deng Hua - Valar Morghulis, Valar Dohaeris
 * @Date: 2018/10/12 12:13
 */
public enum ErrorCode {

    FAILED(0, "FAILED"),
    SUCCESS(1, "SUCCESS"),
    SYSTEM_ERROR(500, "系统异常, 请联系管理员"),
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String parse(Object... args) {
        return MessageFormat.format(message, args);
    }

}
