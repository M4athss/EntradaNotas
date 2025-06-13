package br.com.gestaoconsignado.exception.custom.locations;

import br.com.gestaoconsignado.exception.custom.ApiException;
import org.springframework.http.HttpStatus;

public class LocationEntityNotFoundException extends ApiException {

    public LocationEntityNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
