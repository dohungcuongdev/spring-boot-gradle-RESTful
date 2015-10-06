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
 * Date   10/5/15
 */
@RestController
@EnableAutoConfiguration
public class PasswordController {

    public PasswordValidatorInterface passwordValidatorInterface;

    /**
     * Autowired PasswordValidator bean to do the actual password validation
     * @param passwordValidatorInterface - Interface for password validation rules
     */
    @Autowired
    public PasswordController(PasswordValidatorInterface passwordValidatorInterface) {
        this.passwordValidatorInterface = passwordValidatorInterface;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = "application/json")
    public Response validatePassword(@RequestBody Password password) {

        // Without Spring DI - create a new object and do the password validation
        //PasswordValidator passwordValidator = new PasswordValidator();
        Response response = passwordValidatorInterface.validatePassword(password);

        return response;
    }

}
