package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.dao.CiudadDao;
import com.practice.pragmapocbackendjava.entity.CiudadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CiudadRepository {
    @Autowired
    private CiudadDao ciudadDao;

    public void guardar(CiudadEntity ciudadEntity) {
        ciudadDao.save(ciudadEntity);
    }
}
