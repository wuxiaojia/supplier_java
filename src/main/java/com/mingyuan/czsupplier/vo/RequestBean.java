package com.mingyuan.czsupplier.vo;

import lombok.Data;

@Data
public class RequestBean<T>{
    private T data;
    private String token;
}
