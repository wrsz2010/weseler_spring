package com.javadub1.weseler_spring.user.exceptions;

public class InvalidParameterException  extends RuntimeException{
    public InvalidParameterException(String parameter) {
        super("Invalid value of parameter: " + parameter);
    }
}
