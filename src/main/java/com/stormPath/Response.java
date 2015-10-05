package com.stormPath;

/**
 * Author sumitk
 * Date   10/5/15
 */
public class Response {

    private String response;
    private int responseCode;

    public Response() {

    }

    public Response(int errorCode, String error) {
        this.response = error;
        this.responseCode = errorCode;
    }

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
