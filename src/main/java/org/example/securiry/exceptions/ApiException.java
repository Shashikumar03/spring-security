package org.example.securiry.exceptions;

import lombok.Data;


public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);

    }

    public ApiException() {
        super();

    }

}