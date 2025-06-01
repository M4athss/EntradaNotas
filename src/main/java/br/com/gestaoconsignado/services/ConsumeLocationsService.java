package br.com.gestaoconsignado.services;

import br.com.gestaoconsignado.dto.ConsumeLocationsDTO;
import br.com.gestaoconsignado.entities.ConsumeLocations;
import br.com.gestaoconsignado.repositories.ConsumeLocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumeLocationsService {

    @Autowired
    private ConsumeLocationsRepository consumeLocationRepository;

    public List<ConsumeLocationsDTO> findAll(){
        List<ConsumeLocations> result = consumeLocationRepository.findAll();
        return result.stream().map(ConsumeLocationsDTO::new).toList();
    }

    public ConsumeLocations add(ConsumeLocations location){
        return this.consumeLocationRepository.save(location);
    }

}
