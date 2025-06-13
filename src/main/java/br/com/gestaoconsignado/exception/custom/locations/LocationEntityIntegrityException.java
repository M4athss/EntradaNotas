package br.com.gestaoconsignado.exception.custom.locations;

import br.com.gestaoconsignado.exception.custom.ApiException;
import org.springframework.http.HttpStatus;

public class LocationEntityIntegrityException extends ApiException {

    public LocationEntityIntegrityException(String message, Throwable cause) {
        super(message, cause, HttpStatus.BAD_REQUEST);
    }
}
