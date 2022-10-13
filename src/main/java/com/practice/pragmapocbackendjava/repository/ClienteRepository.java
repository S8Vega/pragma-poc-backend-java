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

import java.util.Optional;

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
        ciudadEntity = ciudadRepository.guardar(ciudadEntity);

        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(clienteDto, ciudadEntity);
        clienteEntity = clienteDao.save(clienteEntity);

        IdentificacionEntity identificacionEntity = clienteMapper.toIdentificacionEntity(clienteDto, clienteEntity);
        identificacionRepository.guardar(identificacionEntity);

        FotoEntity fotoEntity = clienteMapper.toFotoEntity(clienteDto, clienteEntity);
        fotoRepository.guardar(fotoEntity);
    }

    public ClienteDto buscar(String tipoDocumento, String numeroDocumento) {
        Optional<IdentificacionEntity> identificacionEntity = identificacionRepository
                .buscarPorTipoYNumero(tipoDocumento, numeroDocumento);
        if (identificacionEntity.isEmpty()) {
            throw new IllegalArgumentException("No existe documento");
        }
        ClienteEntity clienteEntity = identificacionEntity.get().getCliente();
        return clienteMapper.toClienteDto(clienteEntity);
    }
}
