package br.com.gestaoconsignado.dto;

import br.com.gestaoconsignado.entities.ConsumeLocations;
import jakarta.persistence.Column;

public class ConsumeLocationsDTO {

    private Long id;
    private String code;
    private String name;
    private char active;

    public ConsumeLocationsDTO() {
    }

    public ConsumeLocationsDTO(ConsumeLocations entity) {
        this.id = entity.getId();
        this.code = entity.getCode();
        this.name = entity.getName();
        this.active = entity.getActive();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public char getActive() {
        return active;
    }

}
