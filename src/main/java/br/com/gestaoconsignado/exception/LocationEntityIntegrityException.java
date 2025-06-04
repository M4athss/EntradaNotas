package br.com.gestaoconsignado.exception;

import org.springframework.http.HttpStatus;

public class LocationEntityIntegrityException extends ApiException{

    public LocationEntityIntegrityException(String message, Throwable cause) {
        super(message, cause, HttpStatus.BAD_REQUEST);
    }
}
