package br.com.gestaoconsignado.exception.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocationExceptionDTO {
    private final HttpStatus httpStatus;
    private final String error;
    private final LocalDate date;
    private final LocalTime time;
    private final String pack = "Location";


    public LocationExceptionDTO(HttpStatus httpStatus, String error) {
        this.httpStatus = httpStatus;
        this.error = error;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getError() {
        return error;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getPack() {
        return pack;
    }
}
