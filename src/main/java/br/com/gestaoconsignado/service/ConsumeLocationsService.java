package br.com.gestaoconsignado.service;

import br.com.gestaoconsignado.dto.ConsumeLocationsDTO;
import br.com.gestaoconsignado.entity.ConsumeLocations;
import br.com.gestaoconsignado.exception.LocationEntityIntegrityException;
import br.com.gestaoconsignado.exception.LocationEntityPersistenceException;
import br.com.gestaoconsignado.exception.LocationEntityNotFoundException;
import br.com.gestaoconsignado.repository.ConsumeLocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public void deleteById(Long id){
        consumeLocationRepository.deleteById(id);
    }

    public ConsumeLocations updateById(Long id, ConsumeLocationsDTO location) {
        ConsumeLocations entity = consumeLocationRepository.findById(id)
                .orElseThrow(() -> new LocationEntityNotFoundException("Localização com ID " + id + " não encontrada"));

        entity.setActive(location.getActive());

        if(location.getCode() != null){
            entity.setCode(location.getCode());
        }

        try {
            return consumeLocationRepository.save(entity);
        }catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new LocationEntityIntegrityException("Dados invalidos", e);
        } catch (Exception e){
            e.printStackTrace();
            throw new LocationEntityPersistenceException("Erro ao salvar Location", e);
        }



    }




}
