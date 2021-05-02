package com.jdai.Spring5.SpringAngualrDemo.exception;

import java.util.function.Supplier;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String s) {
        super(s);
    }
}
