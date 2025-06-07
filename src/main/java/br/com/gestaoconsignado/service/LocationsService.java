package br.com.gestaoconsignado.service;

import br.com.gestaoconsignado.dto.LocationsDTO;
import br.com.gestaoconsignado.entity.Locations;
import br.com.gestaoconsignado.exception.*;
import br.com.gestaoconsignado.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsService {

    @Autowired
    private LocationsRepository consumeLocationRepository;

    public List<LocationsDTO> findAll() {
        List<Locations> result = consumeLocationRepository.findAll();
        return result.stream().map(LocationsDTO::new).toList();
    }

    /**
     * Insere em TBLOCAL um novo local. Espera um objetivo do tipo Location
     */
    public Locations add(Locations location) {

        if (consumeLocationRepository.existsById(location.getId())) {
            throw new LocationEntityDuplicateException("O id: " + location.getId() + "ja esta em uso.");
        }
        if (consumeLocationRepository.existsByCode(location.getCode())) {
            throw new LocationEntityDuplicateException("O codigo " + location.getCode() + "ja existe.");
        }
        return this.consumeLocationRepository.save(location);
    }

    /**
     * Remove em TBLOCATIONS baseado no Id.
     */
    public void deleteById(Long id) {
        consumeLocationRepository.deleteById(id);
    }

    public Locations updateById(Long id, LocationsDTO location) {
        Locations entity = consumeLocationRepository.findById(id)
                .orElseThrow(() -> new LocationEntityNotFoundException("Localização com ID " + id + " não encontrada"));

        entity.setActive(location.getActive());

        if (location.getCode() != null) {
            entity.setCode(location.getCode());
        }

        try {
            return consumeLocationRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new LocationEntityIntegrityException("Dados invalidos", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new LocationEntityPersistenceException("Erro ao salvar Location", e);
        }


    }


}
