package com.stormPath;

/**
 * This is the Password class that stores the password for the application
 *
 * Author sumitk
 * Date   10/5/15
 */
public class Password {
    private String password;

    /**
     * Default dummy constructor for Jackson to convert a POJO to JSON
     */
    public Password(){}

    /**
     * Default constructor
     * @param password - The password as String
     */
    public Password(String password) {
        this.password = password;
    }

    // The getters/setters for the Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
