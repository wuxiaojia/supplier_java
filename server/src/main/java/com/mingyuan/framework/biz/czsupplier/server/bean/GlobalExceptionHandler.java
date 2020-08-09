package com.mingyuan.framework.biz.czsupplier.server.bean;

import com.mingyuan.framework.biz.czsupplier.server.dto.ResultDto;
import com.mingyuan.framework.biz.czsupplier.server.enums.CodeEnum;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 全局异常处理
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    private ResultDto exceptionHandler(Exception e) {
        return ResultDto.buildError(CodeEnum.ERROR_COMMON);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    private ResultDto methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        return ResultDto.buildError(CodeEnum.ERROR_COMMON, errors.get(0).getDefaultMessage());
    }
}
