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
            } else if (location.getCode() == null) {
                throw new LocationEntityPersistenceException("Code is empty.");
            } else {
                consumeLocationRepository.save(location);
            }
        } catch (LocationEntityDuplicateException e) {
            throw new LocationEntityDuplicateException(e.getMessage());
        } catch (LocationEntityPersistenceException e) {
            throw new LocationEntityIntegrityException(e.getMessage(), e);
        } catch (Exception e) {
            throw new LocationEntityPersistenceException("Error to save in database", e);
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
            throw new LocationEntityIntegrityException("Dados invalidos", e);
        } catch (Exception e) {
            throw new LocationEntityPersistenceException("Erro ao salvar Location", e);
        }


    }


}
