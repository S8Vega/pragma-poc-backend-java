package com.practice.pragmapocbackendjava.dao;

import com.practice.pragmapocbackendjava.entity.FotoEntity;
import com.practice.pragmapocbackendjava.entity.IdentificacionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FotoDao extends CrudRepository<FotoEntity, Long> {
    Optional<IdentificacionEntity> findByCliente(Long cliente);
}
