package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentJdbcRepository;

@SpringBootApplication(scanBasePackages={
"com.example.demo", "com.example.demo.repository"})
public class Springboot2jdbcwithh2application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentJdbcRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Springboot2jdbcwithh2application.class, args);
    }

    @Override
    public void run(String...args) throws Exception {

        logger.info("student id 10001 -> {}", repository.findbyid(10001));
        logger.info("inserting -> {}", repository.insert(new Student(10010 , "john", "a1234657")));
        logger.info("update 10001 -> {}", repository.update(new Student(10001 , "name-updated", "new-passport")));
        repository.deletebyid(10002 );
        logger.info("all users 2 -> {}", repository.findall()); 
    }
}