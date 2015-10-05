package com.stormPath;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The main controller for handling the requests
 *
 * Author sumitk
 * Date   10/5/15
 */
@RestController
@EnableAutoConfiguration
public class PasswordController {

    @RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = "application/json")
    public Response validatePassword(@RequestBody Password password) {

        PasswordValidator validator = new PasswordValidator();
        Response response = validator.validatePassword(password);

        return response;
    }
}
