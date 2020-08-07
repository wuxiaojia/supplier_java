package com.mingyuan.czsupplier.controller;

import com.mingyuan.czsupplier.vo.LoginVo;
import com.mingyuan.czsupplier.vo.RequestBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("login")
    public void login(@RequestBody RequestBean<LoginVo> requestBean){
        System.out.println(requestBean);
    }
}
