package com.mingyuan.czsupplier.vo;

import lombok.Data;

@Data
public class LoginVo {
    private String username;
    private String password;
    private String isDynamicPassword;
    private String verificationCode;
}
