package com.stormPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The main controller for handling the requests
 *
 * Author sumitk
 * Date   10/6/15
 */
@RestController
@EnableAutoConfiguration
public class PasswordController {

    @Autowired
    public PasswordValidator passwordValidator;

    @RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = "application/json")
    public Response validatePassword(@RequestBody Password password) {

        // Without Spring DI - create a new object and do the password validation
        //PasswordValidator passwordValidator = new PasswordValidator();
        Response response = passwordValidator.validatePassword(password);
        return response;
    }

}
