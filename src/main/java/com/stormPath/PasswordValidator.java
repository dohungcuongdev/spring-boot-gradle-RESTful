package com.stormPath;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import java.util.regex.Pattern;

/**
 * Author sumitk
 * Date   10/5/15
 */

@EnableAutoConfiguration
public class PasswordValidator {

    private final Pattern hasUppercase = Pattern.compile("[A-Z]");
    private final Pattern hasNumber = Pattern.compile("\\d");
    private final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");

    public Response validatePassword(Password password) {

        String passwordToCheck = password.getPassword();

        if (!this.isLengthValid(passwordToCheck)) {
            return new Response(101, "Invalid Password! Password must be between 5 to 12 characters long." + passwordToCheck.length() + "-" + passwordToCheck);
        } else if (this.hasInvalidChars(passwordToCheck)) {
            return new Response(102, "Invalid Password! It can only contain a lowercase letter and number.");
        } else if (this.hasRepeatedSequence(passwordToCheck)) {
            return new Response(103, "Invalid Password! It has same sequence of characters.");
        } else {
            return new Response(200, "Password is valid!");
        }
    }

    public Boolean isLengthValid(String password) {
        if(password.length() < 5 || password.length() > 12) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    public Boolean hasInvalidChars(String password) {

        if (!hasNumber.matcher(password).find() || hasUppercase.matcher(password).find() || hasSpecialChar.matcher(password).find()){
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public Boolean hasRepeatedSequence(String password) {

        for (int slidingWindowSize = 2; slidingWindowSize <= password.length()/2; slidingWindowSize++) {

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
