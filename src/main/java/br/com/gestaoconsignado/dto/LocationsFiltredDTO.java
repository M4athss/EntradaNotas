package br.com.gestaoconsignado.dto;

import br.com.gestaoconsignado.entity.Locations;

public class LocationsFiltredDTO {

    private String code;
    private String name;


    public LocationsFiltredDTO() {
    }

    public LocationsFiltredDTO(Locations entity) {
        this.code = entity.getCode();
        this.name = entity.getName();

    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
