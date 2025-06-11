package br.com.gestaoconsignado.exception.custom;

import org.springframework.http.HttpStatus;

public class LocationEntityPersistenceException extends ApiException{

    public LocationEntityPersistenceException(String message, Throwable cause) {
        super(message, cause, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
