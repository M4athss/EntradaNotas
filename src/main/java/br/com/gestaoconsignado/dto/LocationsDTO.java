package br.com.gestaoconsignado.dto;

import br.com.gestaoconsignado.entity.Locations;

public class LocationsDTO {

    private Long id;
    private String code;
    private String name;
    private boolean active;

    public LocationsDTO() {
    }

    public LocationsDTO(Locations entity) {
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

    public boolean getActive() {
        return active;
    }

}
