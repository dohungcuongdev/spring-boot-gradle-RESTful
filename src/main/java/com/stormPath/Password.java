package com.stormPath;

/**
 * Author sumitk
 * Date   10/5/15
 */
public class Password {
    private String password;

    /**
     * Default dummy constructor for Jackson to convert a POJO to JSON
     */
    public Password(){

    }

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
