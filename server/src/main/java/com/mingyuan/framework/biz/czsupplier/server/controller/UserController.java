package com.mingyuan.framework.biz.czsupplier.server.controller;

import com.mingyuan.framework.biz.czsupplier.server.vo.LoginVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("login")
    public void login(@Valid @RequestBody LoginVo loginVo){
        System.out.println(loginVo);
    }
}
