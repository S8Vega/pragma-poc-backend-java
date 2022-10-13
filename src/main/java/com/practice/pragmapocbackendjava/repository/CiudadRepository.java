package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.dao.CiudadDao;
import com.practice.pragmapocbackendjava.entity.CiudadEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Log4j2
@Repository
public class CiudadRepository {
    @Autowired
    private CiudadDao ciudadDao;

    public CiudadEntity guardar(CiudadEntity ciudadEntity) {
        log.info("Guardar ciudadEntity: " + ciudadEntity);
        Optional<CiudadEntity> oldCiudadEntity = buscarPorNombre(ciudadEntity.getNombre());
        if (oldCiudadEntity.isEmpty()) {
            return ciudadDao.save(ciudadEntity);
        }
        return oldCiudadEntity.get();
    }

    public Optional<CiudadEntity> buscarPorNombre(String nombre) {
        return ciudadDao.findByNombre(nombre);
    }
}
