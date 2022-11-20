package com.dev.projectmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dev.projectmanagementsystem", "security"})
public class ProjectManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementSystemApplication.class, args);
    }

}
