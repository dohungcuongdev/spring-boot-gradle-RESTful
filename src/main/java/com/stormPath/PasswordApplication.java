package com.stormPath;

/**
 * The main Spring Boot Application
 *
 * Author sumitk
 * Date   10/5/15
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PasswordApplication {

    /**
     * The main entry point of the application
     *
     * @param args
     * @throws Exception
     */
    public static void main (String [] args) throws Exception {
        SpringApplication.run(PasswordController.class, args);
    }
}