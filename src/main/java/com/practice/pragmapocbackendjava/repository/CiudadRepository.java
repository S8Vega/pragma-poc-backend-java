package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.entity.CiudadEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CiudadRepository extends CrudRepository<CiudadEntity, Long> {
    Optional<CiudadEntity> findByNombre(String nombre);
}
