package com.mingyuan.framework.biz.czsupplier.server.enums;


public enum CodeEnum {
    SUCCESS(200,"success"),
    ERROR_COMMON(-1,"系统错误，请联系管理员")

    ;
    private Integer code;
    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
