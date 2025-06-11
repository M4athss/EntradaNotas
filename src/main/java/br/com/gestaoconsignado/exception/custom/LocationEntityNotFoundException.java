package br.com.gestaoconsignado.exception.custom;

import org.springframework.http.HttpStatus;

public class LocationEntityNotFoundException extends ApiException{

    public LocationEntityNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
