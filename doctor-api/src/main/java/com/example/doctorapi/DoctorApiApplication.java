
package com.example.doctorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class DoctorApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoctorApiApplication.class, args);
    }
}
