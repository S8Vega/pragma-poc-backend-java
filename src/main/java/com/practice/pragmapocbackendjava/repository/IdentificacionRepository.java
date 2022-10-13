package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.entity.IdentificacionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IdentificacionRepository extends CrudRepository<IdentificacionEntity, Long> {
    Optional<IdentificacionEntity> findByTipoAndNumero(String tipo, String numero);
}
