package com.stormPath;

/**
 * Author sumitk
 * Date   10/5/15
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PasswordApplication {

    public static void main (String [] args) throws Exception {
        SpringApplication.run(PasswordController.class, args);
    }
}