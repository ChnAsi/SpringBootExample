package com.play.frontendapp.frontendapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.play.frontendapp.frontendapp", "com.dataservice.usersdb.contractors"})
public class FrontendappApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontendappApplication.class, args);
    }

}
