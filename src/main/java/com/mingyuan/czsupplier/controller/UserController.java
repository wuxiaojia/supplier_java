package com.mingyuan.czsupplier.controller;

import com.mingyuan.czsupplier.vo.LoginVo;
import com.mingyuan.czsupplier.vo.RequestBean;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("login")
    public void login(@Valid @RequestBody RequestBean<LoginVo> requestBean, BindingResult result){
        if(result.hasErrors()){
            result.getFieldErrors().forEach(item ->{
                System.out.print(item.getDefaultMessage());
            });
        }
    }
}
