package br.com.gestaoconsignado.controllers;

import br.com.gestaoconsignado.dto.ConsumeLocationsDTO;
import br.com.gestaoconsignado.services.ConsumeLocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
