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

    public void guardar(ClienteDto clienteDto) {
        log.info("guardar");
        clienteRepository.guardar(clienteDto);
    }
}
