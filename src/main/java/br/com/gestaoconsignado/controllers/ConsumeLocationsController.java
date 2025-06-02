package br.com.gestaoconsignado.controllers;

import br.com.gestaoconsignado.dto.ConsumeLocationsDTO;
import br.com.gestaoconsignado.entities.ConsumeLocations;
import br.com.gestaoconsignado.services.ConsumeLocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/locations")
public class ConsumeLocationsController {

    @Autowired
    private ConsumeLocationsService consumeLocationsService;

    @GetMapping
    public List<ConsumeLocationsDTO> findALl(){
        return consumeLocationsService.findAll();
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<ConsumeLocationsDTO> insert(@RequestBody ConsumeLocations entity){
        ConsumeLocations insert = consumeLocationsService.add(entity);
        return new ResponseEntity<>(new ConsumeLocationsDTO(insert), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("id") Long id){
        consumeLocationsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
