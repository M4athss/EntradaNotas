package br.com.gestaoconsignado.service;

import br.com.gestaoconsignado.dto.LocationsDTO;
import br.com.gestaoconsignado.entity.Locations;
import br.com.gestaoconsignado.exception.custom.LocationEntityDuplicateException;
import br.com.gestaoconsignado.exception.custom.LocationEntityIntegrityException;
import br.com.gestaoconsignado.exception.custom.LocationEntityNotFoundException;
import br.com.gestaoconsignado.exception.custom.LocationEntityPersistenceException;
import br.com.gestaoconsignado.repository.LocationsRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public void add(Locations location) {

        try {
            if (location.getId() != null || consumeLocationRepository.existsByCode(location.getCode())) {
                throw new LocationEntityDuplicateException("Duplicate ID or CODE!");
            } else {
                consumeLocationRepository.save(location);
            }

        } catch (LocationEntityDuplicateException e) {
            throw new LocationEntityDuplicateException("Duplicate ID or CODE!");
        } catch (Exception e) {
            throw new LocationEntityIntegrityException("Insert new location erro! method add locations.", e);
        }
    }

    public void deleteById(Long id) {
        consumeLocationRepository.deleteById(id);
    }

    public Locations updateById(Long id, @NotNull LocationsDTO location) {
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
