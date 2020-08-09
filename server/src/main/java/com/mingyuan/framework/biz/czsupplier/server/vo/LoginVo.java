package com.mingyuan.framework.biz.czsupplier.server.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginVo {
    @NotBlank(message = "用户名不允许为空")
    private String username;
    @NotBlank(message = "密码不允许为空")
    private String password;
    @NotNull(message = "必须指定是否动态登录")
    private String isDynamicPassword;
    private String verificationCode;
}
