package br.com.gestaoconsignado.exception;

import org.springframework.http.HttpStatus;

public class LocationEntityPersistenceException extends ApiException{

    public LocationEntityPersistenceException(String message, Throwable cause) {
        super(message, cause, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
