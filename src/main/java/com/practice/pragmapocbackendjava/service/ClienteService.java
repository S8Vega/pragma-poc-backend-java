package com.practice.pragmapocbackendjava.service;

import com.practice.pragmapocbackendjava.dto.ClienteDto;
import com.practice.pragmapocbackendjava.repository.ClienteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDto guardar(ClienteDto clienteDto) {
        log.info("guardar");
        return clienteRepository.guardar(clienteDto);
    }

    public ClienteDto buscar(String tipoDocumento, String numeroDocumento) {
        log.info("buscar");
        return clienteRepository.buscar(tipoDocumento, numeroDocumento);
    }

    public ClienteDto actualizar(ClienteDto clienteDto) {
        log.info("actualizar");
        return clienteRepository.actualizar(clienteDto);
    }

    public void eliminar(ClienteDto clienteDto) {
        log.info("eliminar");
        clienteRepository.eliminar(clienteDto);
    }

}
