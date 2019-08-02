package com.talenco.lotterysystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.talenco.lotterysystem.dao")
public class LotterysystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotterysystemApplication.class, args);
    }

}

