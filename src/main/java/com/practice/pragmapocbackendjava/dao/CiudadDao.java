package com.practice.pragmapocbackendjava.dao;

import com.practice.pragmapocbackendjava.entity.CiudadEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CiudadDao extends CrudRepository<CiudadEntity, Long> {
    Optional<CiudadEntity> findByNombre(String nombre);
}
