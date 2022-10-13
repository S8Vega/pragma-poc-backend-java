package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.entity.FotoEntity;
import com.practice.pragmapocbackendjava.entity.IdentificacionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FotoRepository extends CrudRepository<FotoEntity, Long> {
    Optional<IdentificacionEntity> findByCliente(Long cliente);
}
