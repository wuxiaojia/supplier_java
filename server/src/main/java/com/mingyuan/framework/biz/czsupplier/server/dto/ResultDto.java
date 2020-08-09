package com.mingyuan.framework.biz.czsupplier.server.dto;

import com.mingyuan.framework.biz.czsupplier.server.enums.CodeEnum;
import com.sun.tools.javac.jvm.Code;
import lombok.Data;

@Data
public class ResultDto<T> {
    private Boolean result;
    private Integer code;
    private String message;
    private T data;

    /**
     * success返回，自定义data
     * @param data
     * @return
     */
    public static ResultDto buildSuccess(Object data) {
        ResultDto dto = new ResultDto();
        dto.setResult(Boolean.TRUE);
        dto.setCode(CodeEnum.SUCCESS.getCode());
        dto.setMessage(CodeEnum.SUCCESS.getMessage());
        dto.setData(data);
        return dto;
    }

    /**
     * 自定义message
     * @param message
     * @return
     */
    public static ResultDto buildError(String message) {
        ResultDto dto = new ResultDto();
        dto.setResult(Boolean.FALSE);
        dto.setCode(CodeEnum.ERROR_COMMON.getCode());
        dto.setMessage(message);
        dto.setData(null);
        return dto;
    }

    /**
     * 按照codeEnum的定义返回
     *
     * @param codeEnum
     * @return
     */
    public static ResultDto buildError(CodeEnum codeEnum) {
        ResultDto dto = new ResultDto();
        dto.setResult(Boolean.FALSE);
        dto.setCode(codeEnum.getCode());
        dto.setMessage(codeEnum.getMessage());
        dto.setData(null);
        return dto;
    }

    /**
     * 只使用codeEnum的code值，message自定义
     * @param codeEnum
     * @param message
     * @return
     */
    public static ResultDto buildError(CodeEnum codeEnum, String message) {
        ResultDto dto = new ResultDto();
        dto.setResult(Boolean.FALSE);
        dto.setCode(codeEnum.getCode());
        dto.setMessage(message);
        dto.setData(null);
        return dto;
    }

}
