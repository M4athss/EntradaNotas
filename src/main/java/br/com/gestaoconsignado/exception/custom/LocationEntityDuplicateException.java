package br.com.gestaoconsignado.exception.custom;

import org.springframework.http.HttpStatus;

public class LocationEntityDuplicateException extends ApiException {

    public LocationEntityDuplicateException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
