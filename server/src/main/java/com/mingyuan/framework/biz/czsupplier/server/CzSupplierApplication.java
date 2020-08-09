package com.mingyuan.framework.biz.czsupplier.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CzSupplierApplication {

    public static void main(String[] args) {
        SpringApplication.run(CzSupplierApplication.class, args);
    }

}
