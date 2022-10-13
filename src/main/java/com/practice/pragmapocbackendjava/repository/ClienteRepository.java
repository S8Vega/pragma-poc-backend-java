package com.practice.pragmapocbackendjava.repository;

import com.practice.pragmapocbackendjava.dao.ClienteDao;
import com.practice.pragmapocbackendjava.dto.ClienteDto;
import com.practice.pragmapocbackendjava.entity.CiudadEntity;
import com.practice.pragmapocbackendjava.entity.ClienteEntity;
import com.practice.pragmapocbackendjava.entity.FotoEntity;
import com.practice.pragmapocbackendjava.entity.IdentificacionEntity;
import com.practice.pragmapocbackendjava.mapper.ClienteMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class ClienteRepository {

    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private CiudadRepository ciudadRepository;
    @Autowired
    private FotoRepository fotoRepository;
    @Autowired
    private IdentificacionRepository identificacionRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    public void guardar(ClienteDto clienteDto) {
        log.info("Guardar clienteDto: " + clienteDto);
        CiudadEntity ciudadEntity = clienteMapper.toCiudadEntity(clienteDto);
        ciudadRepository.guardar(ciudadEntity);
        FotoEntity fotoEntity = clienteMapper.toFotoEntity(clienteDto);
        fotoRepository.guardar(fotoEntity);
        IdentificacionEntity identificacionEntity = clienteMapper.toIdentificacionEntity(clienteDto);
        identificacionRepository.guardar(identificacionEntity);
        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(clienteDto);
        clienteDao.save(clienteEntity);
    }
}