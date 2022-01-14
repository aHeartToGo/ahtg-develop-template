package com.ahtg.template.global;

public class CommonBizException extends RuntimeException {
    private final String code;
    private final String message;

    public CommonBizException(String message) {
        super(message);
        this.code = "-1";
        this.message = message;
    }

    public CommonBizException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public CommonBizException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public CommonBizException(Throwable cause) {
        super(cause);
        this.code = "-1";
        this.message = cause.getMessage();
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}