package com.company.exceptions;

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException() {

    }

    public ElementNotFoundException(String message) {
        super(message);
    }
}
