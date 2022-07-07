package com.github.jdchawla29.fake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FakeApplication {
    public static void main(String[] args) {
        SpringApplication.run(FakeApplication.class, args);
    }
}