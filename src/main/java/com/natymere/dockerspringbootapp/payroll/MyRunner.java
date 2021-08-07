package com.natymere.dockerspringbootapp.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner is an interface used to indicate that a bean should run when it" +
                "is contained within a SpringApplication.");
    }
}
