package br.com.gestaoconsignado.repository;

import br.com.gestaoconsignado.entity.Locations;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationsRepository extends JpaRepository<Locations, Long> {

    boolean existsByCode(String code);

    boolean existsById(@NotNull Long id);

    List<Locations> findByActiveTrue();

    List<Locations> findByActiveFalse();
}
