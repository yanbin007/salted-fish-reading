package com.saltedfish.reading;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.saltedfish.reading.dao")
public class ReadingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadingApplication.class, args);
    }

}
