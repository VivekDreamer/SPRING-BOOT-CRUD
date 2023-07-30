package com.vivek.springbootcrud.customException;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public ControllerException() {
    }

    public ControllerException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
