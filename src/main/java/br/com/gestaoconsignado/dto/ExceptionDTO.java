package br.com.gestaoconsignado.dto;

import org.springframework.http.HttpStatus;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ExceptionDTO {
    private final int httpStatus;
    private final String error;
    private final LocalDate date;
    private final LocalTime time;


    public ExceptionDTO(int httpStatus, String error) {
        this.httpStatus = httpStatus;
        this.error = error;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public int getHttpStatus() {
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
}
