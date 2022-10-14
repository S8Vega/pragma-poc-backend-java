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

    public ClienteDto guardar(ClienteDto clienteDto) {
        log.info("Guardar clienteDto: " + clienteDto);

        CiudadEntity ciudadEntity = clienteMapper.toCiudadEntity(clienteDto);
        ciudadEntity = ciudadRepository.guardar(ciudadEntity);

        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(clienteDto, ciudadEntity);
        clienteEntity = clienteDao.save(clienteEntity);

        IdentificacionEntity identificacionEntity = clienteMapper.toIdentificacionEntity(clienteDto, clienteEntity);
        identificacionRepository.guardar(identificacionEntity);

        FotoEntity fotoEntity = clienteMapper.toFotoEntity(clienteDto, clienteEntity);
        fotoRepository.guardar(fotoEntity);

        return clienteDto;
    }

    public ClienteDto buscar(String tipoDocumento, String numeroDocumento) {
        Optional<ClienteEntity> clienteEntity = clienteDao.findByIdentificacion(tipoDocumento, numeroDocumento);
        if (clienteEntity.isEmpty()) {
            throw new IllegalArgumentException("El documento no existe");
        }
        return clienteMapper.toClienteDto(clienteEntity.get());
    }

    public ClienteDto actualizar(ClienteDto clienteDto) {
        Optional<ClienteEntity> optionalClienteEntity = clienteDao.findByIdentificacion(
                clienteDto.getTipoIdentificacion(), clienteDto.getNumeroIdentificacion());
        if (optionalClienteEntity.isEmpty()) {
            throw new IllegalArgumentException("El documento no existe");
        }
        ClienteEntity clienteEntity = optionalClienteEntity.get();
        clienteEntity.setNombres(clienteDto.getNombres());
        clienteEntity.setApellidos(clienteDto.getApellidos());
        clienteEntity.setEdad(clienteDto.getEdad());
        clienteEntity.getCiudadDeNacimiento().setNombre(clienteDto.getCiudadDeNacimiento());
        clienteEntity.getFoto().setBase64(clienteDto.getFoto());
        clienteDao.save(clienteEntity);
        return buscar(clienteDto.getTipoIdentificacion(), clienteDto.getNumeroIdentificacion());
    }
}
