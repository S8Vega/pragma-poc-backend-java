package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.dao.IdentificacionDao;
import com.practice.pragmapocbackendjava.entity.IdentificacionEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Log4j2
@Repository
public class IdentificacionRepository {
    @Autowired
    private IdentificacionDao identificacionDao;

    public void guardar(IdentificacionEntity identificacionEntity) {
        log.info("Guardar identificacionEntity: " + identificacionEntity);
        Optional<IdentificacionEntity> oldIdentificacionEntity = buscarPorTipoYNumero(identificacionEntity.getTipo(),
                identificacionEntity.getNumero());
        if (oldIdentificacionEntity.isPresent()) {
            throw new IllegalStateException("La identificacion ya existe");
        }
        identificacionDao.save(identificacionEntity);
    }

    public Optional<IdentificacionEntity> buscarPorTipoYNumero(String tipo, String numero) {
        return identificacionDao.findByTipoAndNumero(tipo, numero);
    }
}
