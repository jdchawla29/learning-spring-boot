package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student jaideep = new Student(
                    1L,
                    "Jaideep",
                    LocalDate.of(2001, Month.SEPTEMBER, 29),
                    "jdchawla29@gmail.com");

            Student alex = new Student(
                    "Alex",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "alex@gmail.com");

            repository.saveAll(
                    List.of(jaideep, alex));
        };
    }
}
