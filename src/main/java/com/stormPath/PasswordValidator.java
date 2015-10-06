package com.stormPath;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * The validator class that checks for the validity of the password
 *
 * Author sumitk
 * Date   10/5/15
 */

@Component
public class PasswordValidator implements PasswordValidatorInterface {

    /**
     * Regex patters for simple matching
     */
    private final Pattern hasUppercase   = Pattern.compile("[A-Z]");
    private final Pattern hasLowercase   = Pattern.compile("[a-z]");
    private final Pattern hasNumber      = Pattern.compile("\\d");
    private final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");

    /**
     * This function validates the password according to the rules
     *
     * @param password - The password that needs to be validated
     *
     * @return Response - A custom response object with a response code
     */
    public Response validatePassword(Password password) {

        String passwordToCheck = password.getPassword();

        if (!this.isLengthValid(passwordToCheck)) {
            return new Response(101, "Invalid Password! Password must be between 5 to 12 characters long.");
        } else if (this.hasInvalidChars(passwordToCheck)) {
            return new Response(102, "Invalid Password! It can only contain a lowercase letter and number.");
        } else if (this.hasRepeatedSequence(passwordToCheck)) {
            return new Response(103, "Invalid Password! It has same sequence of characters.");
        } else {
            return new Response(200, "Password is valid!");
        }
    }

    /**
     * This function checks the length of the password and returns TRUE/FALSE
     *
     * @param password - The password that needs to be validated
     *
     * @return Boolean - The result of validation
     */
    public Boolean isLengthValid(String password) {
        if(password.length() < 5 || password.length() > 12) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    /**
     * This function checks if the password has invalid characters [It should not have any uppercase letter or any special characters]
     *
     * @param password - The password that needs to be validated
     *
     * @return Boolean - The result of validation
     */
    public Boolean hasInvalidChars(String password) {

        if (!hasNumber.matcher(password).find()             // handle no number present
                || hasUppercase.matcher(password).find()    // handle uppercase letter
                || hasSpecialChar.matcher(password).find()  // handle special characters
                || (hasNumber.matcher(password).find() && !hasLowercase.matcher(password).find()) // handle only number present
        ){
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * This function checks if the password has any sequence of characters tha are being repeated immediately
     *
     * @param password - The password that needs to be validated
     *
     * @return Boolean - The result of validation
     */
    public Boolean hasRepeatedSequence(String password) {

        // Sliding window is the size of the substring that needs to be checked for repetition
        for (int slidingWindowSize = 1; slidingWindowSize <= password.length()/2; slidingWindowSize++) {

            // We only need to go to the position after which the window size equals the remaining character in the string
            for (int position = 0; position < password.length() - (slidingWindowSize * 2) + 1; position++) {

                String toMatch = password.substring(position, position + slidingWindowSize);
                String nextSeq = password.substring(position + slidingWindowSize, position + slidingWindowSize * 2);

                if (toMatch.equals(nextSeq)) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }
}
