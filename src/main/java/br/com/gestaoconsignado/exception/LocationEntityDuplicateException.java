package br.com.gestaoconsignado.exception;

import org.springframework.http.HttpStatus;

public class LocationEntityDuplicateException extends ApiException {

    public LocationEntityDuplicateException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
