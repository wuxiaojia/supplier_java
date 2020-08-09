package com.mingyuan.framework.biz.czsupplier.server.vo;

import lombok.Data;

import javax.validation.Valid;

@Data
public class RequestBean<T>{
    private T data;
    private String token;
}
