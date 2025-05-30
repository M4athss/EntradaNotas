package br.com.gestaoconsignado.repositories;

import br.com.gestaoconsignado.entities.ConsumeLocations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumeLocationsRepository extends JpaRepository<ConsumeLocations, Long> {
}
