package br.com.gestaoconsignado.exception;

import org.springframework.http.HttpStatus;

public class LocationEntityNotFoundException extends ApiException{

    public LocationEntityNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
