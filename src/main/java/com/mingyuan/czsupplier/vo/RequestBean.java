package com.mingyuan.czsupplier.vo;

import lombok.Data;

import javax.validation.Valid;

@Data
public class RequestBean<T>{
    private T data;
    private String token;
}
