package com.example.androidthesisserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.androidthesisserver.mapper")
public class AndroidThesisServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AndroidThesisServerApplication.class, args);
    }

}
