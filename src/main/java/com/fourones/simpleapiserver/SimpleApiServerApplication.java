package com.fourones.simpleapiserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.fourones.simpleapiserver.**")
@Slf4j
@SpringBootApplication
public class SimpleApiServerApplication implements CommandLineRunner {

    //    java -Dspring.datasource.initialize=false -jar target/SimpleApiServerApplication.jar
    public static void main(String[] args) {
        SpringApplication.run(SimpleApiServerApplication.class, args);
    }

    @Override
    public void run(String... strings) {

    }
}
