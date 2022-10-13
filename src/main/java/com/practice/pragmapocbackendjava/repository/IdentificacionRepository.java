package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.dao.IdentificacionDao;
import com.practice.pragmapocbackendjava.entity.IdentificacionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdentificacionRepository {
    @Autowired
    private IdentificacionDao identificacionDao;

    public void guardar(IdentificacionEntity identificacionEntity) {
        identificacionDao.save(identificacionEntity);
    }
}
