package com.mufan.custompackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author YuXingZh
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.mufan.custompackage.dao")
public class CustomPackageApplication {

    /**
     * 服务启动类
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CustomPackageApplication.class, args);
    }

}

