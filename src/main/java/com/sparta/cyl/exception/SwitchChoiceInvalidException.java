package com.sparta.cyl.exception;

public class SwitchChoiceInvalidException extends RuntimeException{
    public SwitchChoiceInvalidException(){};

    public SwitchChoiceInvalidException(String errorMessage){
        super(errorMessage);
    };

    public SwitchChoiceInvalidException(Throwable cause){
        super(cause);
    }
}

