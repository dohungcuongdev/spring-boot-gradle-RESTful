package com.stormPath;

import org.springframework.stereotype.Repository;

/**
 * Author sumitk
 * Date   10/6/15
 */
@Repository
public interface PasswordValidatorInterface {

    public Response validatePassword(Password password);
    public Boolean isLengthValid(String password);
    public Boolean hasInvalidChars(String password);
    public Boolean hasRepeatedSequence(String password);

}
