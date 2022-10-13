package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.dao.FotoDao;
import com.practice.pragmapocbackendjava.entity.FotoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FotoRepository {
    @Autowired
    private FotoDao fotoDao;

    public void guardar(FotoEntity fotoEntity) {
        fotoDao.save(fotoEntity);
    }
}
