package com.stormPath;

/**
 * The main Spring Boot Application
 *
 * Author sumitk
 * Date   10/6/15
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// same as @Configuration + @ComponentScan + @EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.stormPath")
public class PasswordApplication {

    /**
     * The main entry point of the application
     *
     * @param args
     * @throws Exception
     */
    public static void main (String [] args) throws Exception {
        SpringApplication.run(PasswordApplication.class, args);
    }
}