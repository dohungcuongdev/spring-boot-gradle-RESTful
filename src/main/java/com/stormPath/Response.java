package com.stormPath;

/**
 * A custom response class that sends a Response object with message and a code for the processed request
 *
 * Author sumitk
 * Date   10/5/15
 */
public class Response {

    private String response;
    private int responseCode;

    /**
     * Dummy constructor for Jackson
     */
    public Response() {}

    /**
     * Default constructor
     *
     * @param responseCode - The code for the response
     * @param message      - The response message
     */
    public Response(int responseCode, String message) {
        this.response = message;
        this.responseCode = responseCode;
    }

    // The getters/setters for the class variables
    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {

        this.responseCode = responseCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
