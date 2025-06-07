package br.com.gestaoconsignado.controller;

import br.com.gestaoconsignado.dto.LocationsDTO;
import br.com.gestaoconsignado.entity.Locations;
import br.com.gestaoconsignado.exception.ApiException;
import br.com.gestaoconsignado.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/locations")
public class LocationsController {

    @Autowired
    private LocationsService locationsService;

    @GetMapping
    public List<LocationsDTO> findALl(){
        return locationsService.findAll();
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<LocationsDTO> insert(@RequestBody Locations entity){
        Locations insert = locationsService.add(entity);
        return new ResponseEntity<>(new LocationsDTO(insert), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("id") Long id){
        locationsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LocationsDTO> alterStatus(@PathVariable Long id, @RequestBody LocationsDTO request){
        try {
            Locations input = locationsService.updateById(id, request);

            return new ResponseEntity<>(new LocationsDTO(input), HttpStatus.ACCEPTED);

        } catch (ApiException e){
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }

}
