package br.com.gestaoconsignado.exception.handler;

import br.com.gestaoconsignado.exception.custom.LocationEntityDuplicateException;
import br.com.gestaoconsignado.exception.model.ExceptionDTO;
import org.hibernate.tool.schema.spi.ExecutionOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LocationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<ExceptionDTO> locationEntityDuplicateHandler(LocationEntityDuplicateException exception){
        ExceptionDTO e = new ExceptionDTO(exception.getHttpStatus(), exception.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(e);
    }
}
