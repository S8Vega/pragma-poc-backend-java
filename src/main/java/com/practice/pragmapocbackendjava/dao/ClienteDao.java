package com.practice.pragmapocbackendjava.dao;

import com.practice.pragmapocbackendjava.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteDao extends CrudRepository<ClienteEntity, Long> {
    Optional<List<ClienteEntity>> findByEdadGreaterThanEqual(Integer edad);
}
