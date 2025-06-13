package br.com.gestaoconsignado.exception.handler;

import br.com.gestaoconsignado.exception.custom.locations.LocationEntityDuplicateException;
import br.com.gestaoconsignado.exception.custom.locations.LocationEntityIntegrityException;
import br.com.gestaoconsignado.exception.custom.locations.LocationEntityNotFoundException;
import br.com.gestaoconsignado.exception.custom.locations.LocationEntityPersistenceException;
import br.com.gestaoconsignado.exception.model.LocationExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LocationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<LocationExceptionDTO> locationEntityDuplicateHandler(LocationEntityDuplicateException exception){
        LocationExceptionDTO e = new LocationExceptionDTO(exception.getHttpStatus(), exception.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(e);
    }

    @ExceptionHandler
    private ResponseEntity<LocationExceptionDTO> locationEntityIntegrityHandler(LocationEntityIntegrityException exception){
        LocationExceptionDTO e = new LocationExceptionDTO(exception.getHttpStatus(), exception.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(e);
    }

    @ExceptionHandler
    private ResponseEntity<LocationExceptionDTO> locationEntityPersistenceHandler(LocationEntityPersistenceException exception){
        LocationExceptionDTO e = new LocationExceptionDTO(exception.getHttpStatus(), exception.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(e);
    }

    @ExceptionHandler
    private ResponseEntity<LocationExceptionDTO> locationEntityNotFoundHandler(LocationEntityNotFoundException exception){
        LocationExceptionDTO e = new LocationExceptionDTO(exception.getHttpStatus(), exception.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(e);
    }
}
