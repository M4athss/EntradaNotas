package br.com.gestaoconsignado.service;

import br.com.gestaoconsignado.dto.LocationsDTO;
import br.com.gestaoconsignado.dto.LocationsFiltredDTO;
import br.com.gestaoconsignado.entity.Locations;
import br.com.gestaoconsignado.exception.custom.locations.LocationEntityDuplicateException;
import br.com.gestaoconsignado.exception.custom.locations.LocationEntityIntegrityException;
import br.com.gestaoconsignado.exception.custom.locations.LocationEntityNotFoundException;
import br.com.gestaoconsignado.exception.custom.locations.LocationEntityPersistenceException;
import br.com.gestaoconsignado.repository.LocationsRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationsService {

    @Autowired
    private LocationsRepository consumeLocationRepository;

    public List<LocationsDTO> findAll() {
        List<Locations> result = consumeLocationRepository.findAll();
        return result.stream().map(LocationsDTO::new).toList();
    }

    public LocationsDTO findById(Long id) {
        Locations location = consumeLocationRepository.findById(id)
                .orElseThrow(() -> new LocationEntityNotFoundException("ID " + id + " Not exists"));
        return new LocationsDTO(location);
    }

    public List<LocationsFiltredDTO> findByActive() {
        List<Locations> result = consumeLocationRepository.findByActiveTrue();
        return result.stream().map(LocationsFiltredDTO::new).toList();
    }

    public List<LocationsFiltredDTO> findByInactive() {
        List<Locations> result = consumeLocationRepository.findByActiveFalse();
        return result.stream().map(LocationsFiltredDTO::new).toList();
    }

    public void add(Locations location) {
        try {
            if (location.getId() != null || consumeLocationRepository.existsByCode(location.getCode())) {
                throw new LocationEntityDuplicateException("Duplicate ID or CODE!");
            } else if (location.getCode() == null) {
                throw new LocationEntityPersistenceException("Code is empty.");
            } else if (location.getCode().length() > 3) {
                throw new LocationEntityPersistenceException("Code has more than 3 characters");
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
                .orElseThrow(() -> new LocationEntityNotFoundException(id + " Not Found!"));
        entity.setActive(location.getActive());
        if (location.getName() != null) {
            entity.setName(location.getName());
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
