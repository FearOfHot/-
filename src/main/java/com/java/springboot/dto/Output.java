package com.java.springboot.dto;

public class Output {

    private String code;
    private String message;

    public Output(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Output{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
