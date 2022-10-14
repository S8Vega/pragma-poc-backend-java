package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.dao.FotoDao;
import com.practice.pragmapocbackendjava.entity.FotoEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class FotoRepository {
    @Autowired
    private FotoDao fotoDao;

    public void guardar(FotoEntity fotoEntity) {
        log.info("Guardar fotoEntity: " + fotoEntity);
        fotoDao.save(fotoEntity);
    }

    public void eliminar(FotoEntity fotoEntity) {
        log.info("Eliminar");
        fotoDao.delete(fotoEntity);
    }
}
