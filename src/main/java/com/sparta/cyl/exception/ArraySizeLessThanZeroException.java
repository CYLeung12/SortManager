package com.sparta.cyl.exception;

public class ArraySizeLessThanZeroException extends RuntimeException{
    public ArraySizeLessThanZeroException(){};

    public ArraySizeLessThanZeroException(String errorMessage){
        super(errorMessage);
    };

    public ArraySizeLessThanZeroException(Throwable cause){
        super(cause);
    }
}
